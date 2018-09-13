package com.jzg.svsp.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//,fallback = CustomerServiceImpl.class
@FeignClient(name = "customer")
public interface CustomerService {
    @GetMapping("/getCustomerById/{customerId}")
    public String getCustomerById(@PathVariable("customerId") Long customerId);
}
