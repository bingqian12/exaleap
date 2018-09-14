package com.jzg.svsp.customer.service;

import com.jzg.svsp.common.vo.ResultVo;
import com.jzg.svsp.customer.entity.CustomerLogin;

public interface ICustomerLoginService {


    CustomerLogin findByCustomerId(Long customerId);

    CustomerLogin createCustomer(String mobile);

    void saveLoginLog(Long customerId, Byte loginType);

    ResultVo loginByValidateCode(String mobile, String validateCode);
}
