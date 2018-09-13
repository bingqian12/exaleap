package com.jzg.svsp.product.controller;


import com.alibaba.fastjson.JSON;
import com.jzg.svsp.common.vo.LoginCustomerVo;
import com.jzg.svsp.product.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("product")
public class IndexController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/product/{productId}")
    public String info(@PathVariable("productId") Long productId){

        Long customerId = 3L;
        LoginCustomerVo customerVo = customerService.getCustomerById(customerId);
        return "product_"+productId  + "  " + JSON.toJSONString(customerVo);
    }
}
