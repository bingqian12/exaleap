package com.jzg.svsp.customer.controller;


import com.jzg.svsp.common.vo.LoginCustomerVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("customer")
public class IndexController {


    @GetMapping("getCustomerById/{customerId}")
    public LoginCustomerVo getCustomerById(@PathVariable("customerId") Long customerId){

        LoginCustomerVo customerVO = new LoginCustomerVo();
        customerVO.setCustomerId(111L);
        customerVO.setMobilePhone(13811111111L);
        customerVO.setLoginName("abcd");
        customerVO.setPassword("md5'str'");
        customerVO.setUserStats(1);



        return customerVO;
    }
}
