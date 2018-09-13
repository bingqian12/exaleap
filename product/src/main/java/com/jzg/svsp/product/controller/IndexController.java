package com.jzg.svsp.product.controller;


import com.jzg.svsp.product.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("product")
public class IndexController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/product/{productId}")
    public String info(@PathVariable("productId") Long productId){

        Long customerId = 3L;
//        +
        return "product_"+productId  + "  "+ customerService.getCustomerById(customerId);
    }
}
