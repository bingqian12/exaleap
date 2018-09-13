package com.jzg.svsp.customer.service.impl;

import com.jzg.svsp.customer.dao.CustomerLoginMapper;
import com.jzg.svsp.customer.entity.CustomerLogin;
import com.jzg.svsp.customer.service.ICustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "customerLoginService")
public class CustomerLoginService implements ICustomerLoginService {


    @Autowired
    CustomerLoginMapper customerLoginMapper;

    @Override
    public CustomerLogin findByCustomerId(Long customerId) {
        return  customerLoginMapper.selectByPrimaryKey(customerId);
    }
}
