package com.jzg.svsp.customer.controller;


import com.jzg.svsp.common.vo.CustomerLoginVo;
import com.jzg.svsp.customer.entity.CustomerLogin;
import com.jzg.svsp.customer.service.ICustomerLoginService;
import com.jzg.svsp.customer.service.impl.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("customer")
public class IndexController {


    @Autowired
    ICustomerLoginService customerLoginService ;
    @GetMapping("getCustomerById/{customerId}")
    public CustomerLoginVo getCustomerById(@PathVariable("customerId") Long customerId){

        CustomerLoginVo customerVO = new CustomerLoginVo();
        CustomerLogin customerLogin = customerLoginService.findByCustomerId(1L);
        if(customerLogin == null ){

            customerVO.setCustomerId(111L);
            customerVO.setLoginName("abcd");
            customerVO.setMobilePhone(234234234L);
            customerVO.setPassword("md5");
            customerVO.setUserStats(1);

        }else {

            customerVO.setCustomerId(customerLogin.getCustomerId());
            customerVO.setPassword(customerLogin.getPassword());
            customerVO.setMobilePhone(customerLogin.getMobilePhone());
            customerVO.setLoginName(customerLogin.getLoginName());
            customerVO.setPassword(customerLogin.getPassword());
            customerVO.setUserStats(customerLogin.getUserStats());


        }



        return customerVO;
    }
}
