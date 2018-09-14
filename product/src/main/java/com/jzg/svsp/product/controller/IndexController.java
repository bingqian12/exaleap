package com.jzg.svsp.product.controller;


import com.alibaba.fastjson.JSON;
import com.jzg.svsp.common.vo.login.CustomerLoginVo;
import com.jzg.svsp.product.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@Api(value = "IndexController|  一个用来测试swagger注解的控制器")
//@RequestMapping("product")
public class IndexController {

    @Autowired
    CustomerService customerService;

    @ApiOperation(value="根据商品ID 获取商品详细信息", notes="   测试  ")
    @GetMapping("/api/{productId}")
    public String info(@PathVariable("productId") Long productId){

        Long customerId = 3L;
        CustomerLoginVo customerVo = customerService.getCustomerById(customerId);
//        return "product_"+productId  + "  " + JSON.toJSONString(customerVo);


        log.info(JSON.toJSONString(customerVo));

        return "hello "+ JSON.toJSONString(customerVo);
    }
}
