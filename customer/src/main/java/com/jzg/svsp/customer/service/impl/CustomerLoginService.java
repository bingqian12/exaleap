package com.jzg.svsp.customer.service.impl;

import com.jzg.svsp.common.util.IpUtils;
import com.jzg.svsp.common.util.Md5Encrypt;
import com.jzg.svsp.common.util.RandomUtils;
import com.jzg.svsp.common.util.WebUtils;
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
public class CustomerLoginService implements ICustomerLoginService {


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
        ResultVo resultVo = new ResultVo();
        String _validateCode = redisClient.get(Constants.VALIDATE_CODE_PREFIX + mobile);
        if (StringUtils.isBlank(_validateCode) || !validateCode.equals(_validateCode)) {
            resultVo.setStatus(RetStatus.InValid.getValue());
            resultVo.setMsg("验证码错误");
            return resultVo;
        }

        CustomerLogin customerLogin = createCustomer(mobile);
        if (customerLogin != null) {
            saveLoginLog(customerLogin.getCustomerId(), new Byte("1"));
        }else{
            resultVo.setStatus(RetStatus.InValid.getValue());
            resultVo.setMsg("登录失败");
            return resultVo;
        }

        CustomerLoginVo loginVo = new CustomerLoginVo();
        loginVo.setCustomerId(customerLogin.getCustomerId());
        loginVo.setLoginName(customerLogin.getLoginName());
        loginVo.setMobilePhone(customerLogin.getMobilePhone());
        loginVo.setUserStats(customerLogin.getUserStats());

        String token = UUID.randomUUID().toString();
        redisClient.set(token, mobile, Constants.TOKEN_EFFECTIVE_TIME);
        redisClient.set(Constants.TOKEN_PREFIX + mobile, token, Constants.TOKEN_EFFECTIVE_TIME);

        resultVo.setData(loginVo);
        resultVo.setStatus(RetStatus.Ok.getValue());
        resultVo.setMsg("登录成功");
        return resultVo;
    }

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
