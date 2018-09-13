package com.jzg.svsp.product.controller;


import com.alibaba.fastjson.JSON;
import com.jzg.svsp.common.vo.CustomerLoginVo;
import com.jzg.svsp.product.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
//@RequestMapping("product")
public class IndexController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/product/{productId}")
    public String info(@PathVariable("productId") Long productId){

        Long customerId = 3L;
        CustomerLoginVo customerVo = customerService.getCustomerById(customerId);
//        return "product_"+productId  + "  " + JSON.toJSONString(customerVo);


        log.info(JSON.toJSONString(customerVo));

        return "hello "+ JSON.toJSONString(customerVo);
    }
}
