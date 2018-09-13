package com.jzg.svsp.customer.controller;


import com.jzg.svsp.common.vo.CustomerLoginVo;
import com.jzg.svsp.customer.entity.CustomerLogin;
import com.jzg.svsp.customer.service.ICustomerLoginService;
import com.jzg.svsp.customer.service.impl.CustomerLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController

@Api(value = "IndexController|  一个用来测试swagger注解的控制器")
//@RequestMapping("customer")
public class IndexController {


    @Autowired
    ICustomerLoginService customerLoginService ;

    @ApiOperation(value="根据用户编号获取用户详细信息", notes="test: 仅1和2有正确返回")
//    @ApiImplicitParam(paramType="query", name = "customerId", value = "客户编号", required = true, dataType = "Long")
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
