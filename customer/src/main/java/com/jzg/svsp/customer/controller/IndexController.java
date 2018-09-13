package com.jzg.svsp.customer.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("customer")
public class IndexController {


    @GetMapping("getCustomerById/{customerId}")
    public String getCustomerById(@PathVariable("customerId") Long customerId){
        return "customerId_"+customerId;
    }
}
