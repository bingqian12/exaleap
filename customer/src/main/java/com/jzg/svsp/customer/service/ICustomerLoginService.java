package com.jzg.svsp.customer.service;

import com.jzg.svsp.common.vo.ResultVo;
import com.jzg.svsp.customer.entity.CustomerLogin;

public interface ICustomerLoginService {


    /**
     * 根据Id获取用户信息
     * @param customerId
     * @return
     */
    CustomerLogin findByCustomerId(Long customerId);

    /**
     * 如果用户不存在 则创建用户
     * @param mobile
     * @return
     */
    CustomerLogin createCustomer(String mobile);

    /**
     * 保存登录日志
     * @param customerId
     * @param loginType
     */
    void saveLoginLog(Long customerId, Byte loginType);

    /**
     * 验证码登录
     * @param mobile
     * @param validateCode
     * @return
     */
    ResultVo loginByValidateCode(String mobile, String validateCode);
}
