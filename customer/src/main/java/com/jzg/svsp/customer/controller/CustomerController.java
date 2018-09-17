package com.jzg.svsp.customer.controller;

import com.jzg.svsp.common.vo.ResultVo;
import com.jzg.svsp.customer.service.ICustomerLoginService;
import com.jzg.svsp.customer.service.ISmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:22 on 2018/9/14.
 */
@RestController
@Api(value = "customerController|用户控制器")
@Slf4j
public class CustomerController {

    @Autowired
    ICustomerLoginService customerLoginService;

    @Autowired
    ISmsService smsService;

    @ApiOperation(value = "发送验证码", notes = "发送验证码")
    @PostMapping("sendValidateCode")
    public ResultVo sendValidateCode(@RequestParam(value = "mobile") String mobile) {
        return smsService.sendValidateCode(mobile);
    }

    @ApiOperation(value = "验证码登录", notes = "验证码登录")
    @PostMapping("loginByValidateCode")
    public ResultVo loginByValidateCode(@RequestParam(value = "mobile") String mobile, @RequestParam(value = "validateCode") String validateCode) {
        return customerLoginService.loginByValidateCode(mobile, validateCode);
    }
}
