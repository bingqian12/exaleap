package com.jzg.svsp.customer.service.impl;

import com.jzg.svsp.common.enums.HttpStatusEnum;
import com.jzg.svsp.common.util.*;
import com.jzg.svsp.common.vo.Constants;
import com.jzg.svsp.common.vo.ResultVo;
import com.jzg.svsp.common.vo.RetStatus;
import com.jzg.svsp.common.vo.login.CustomerLoginVo;
import com.jzg.svsp.customer.config.RedisClient;
import com.jzg.svsp.customer.dao.CustomerInfMapper;
import com.jzg.svsp.customer.dao.CustomerLoginLogMapper;
import com.jzg.svsp.customer.dao.CustomerLoginMapper;
import com.jzg.svsp.customer.entity.CustomerInf;
import com.jzg.svsp.customer.entity.CustomerLogin;
import com.jzg.svsp.customer.entity.CustomerLoginLog;
import com.jzg.svsp.customer.service.ICustomerLoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Service(value = "customerLoginService")
public class CustomerLoginServiceImpl implements ICustomerLoginService {


    @Autowired
    CustomerLoginMapper customerLoginMapper;

    @Autowired
    CustomerLoginLogMapper customerLoginLogMapper;

    @Autowired
    CustomerInfMapper customerInfMapper;

    @Autowired
    RedisClient redisClient;

    @Override
    public CustomerLogin findByCustomerId(Long customerId) {
        return customerLoginMapper.selectByPrimaryKey(customerId);
    }

    @Override
    public CustomerLogin createCustomer(String mobile) {
        CustomerLogin customerLogin = customerLoginMapper.selectByMobilePhone(Long.valueOf(mobile));
        if (customerLogin != null) {
            return customerLogin;
        }
        customerLogin = new CustomerLogin();
        customerLogin.setPassword(Md5Encrypt.toHexStringUpper((RandomUtils.getValidateCode() + "").getBytes()));
        customerLogin.setLoginName(mobile);
        customerLogin.setMobilePhone(Long.valueOf(mobile));
        int count = customerLoginMapper.insertSelective(customerLogin);
        if (count > 0) {
            customerLogin = customerLoginMapper.selectByMobilePhone(Long.parseLong(mobile));
            CustomerInf customerInf = new CustomerInf();
            customerInf.setCustomerId(customerLogin.getCustomerId());
            customerInfMapper.insertSelective(customerInf);
        } else {
            customerLogin = null;
        }

        return customerLogin;
    }

    @Override
    public ResultVo loginByValidateCode(String mobile, String validateCode) {
        String redisValidateCode = redisClient.get(Constants.VALIDATE_CODE_PREFIX + mobile);
        if (StringUtils.isBlank(redisValidateCode) || !validateCode.equals(redisValidateCode)) {
            return ResultUtils.fail(HttpStatusEnum.NO_CONTENT.code(), "验证码错误");
        }

        CustomerLogin customerLogin = createCustomer(mobile);
        if (customerLogin != null) {
            saveLoginLog(customerLogin.getCustomerId(), new Byte("1"));
        }else{
            return ResultUtils.fail(HttpStatusEnum.NO_CONTENT.code(), "登录失败");
        }

        CustomerLoginVo loginVo = new CustomerLoginVo();
        loginVo.setCustomerId(customerLogin.getCustomerId());
        loginVo.setLoginName(customerLogin.getLoginName());
        loginVo.setMobilePhone(customerLogin.getMobilePhone());
        loginVo.setUserStats(customerLogin.getUserStats());

        //生成token 存入redis
        String token = UUID.randomUUID().toString();
        redisClient.set(token, mobile, Constants.TOKEN_EFFECTIVE_TIME);
        redisClient.set(Constants.TOKEN_PREFIX + mobile, token, Constants.TOKEN_EFFECTIVE_TIME);

        return ResultUtils.success(loginVo, HttpStatusEnum.OK.code(), "登录成功");
    }

    /**
     * 获取登录ip
     * @return
     */
    private String getIpAddress() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return WebUtils.getIpAddress(request);
    }

    /**
     * 保存登录日志
     *
     * @param customerId
     * @param loginType
     */
    @Override
    public void saveLoginLog(Long customerId, Byte loginType) {
        CustomerLoginLog record = new CustomerLoginLog();
        record.setCustomerId(customerId);
        record.setLoginIp(IpUtils.ipToLong(getIpAddress()));
        record.setLoginType(loginType);
        customerLoginLogMapper.insertSelective(record);
    }
}
