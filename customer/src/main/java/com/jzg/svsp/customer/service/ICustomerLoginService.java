package com.jzg.svsp.customer.service;

import com.jzg.svsp.customer.entity.CustomerLogin;

public interface ICustomerLoginService {


    CustomerLogin findByCustomerId ( Long customerId);
}
