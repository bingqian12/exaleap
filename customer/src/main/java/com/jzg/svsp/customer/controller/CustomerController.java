package com.jzg.svsp.customer.controller;

import com.jzg.svsp.common.vo.ResultVo;
import com.jzg.svsp.customer.service.ICustomerLoginService;
import com.jzg.svsp.customer.service.ISmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @ApiOperation(value = "发送验证码",tags={"通过电话号码，获取短信验证码"}, notes = "注意限制固定时间内发送验证码的个数")
    @PostMapping("sendValidateCode")
    public ResultVo sendValidateCode(@ApiParam(name="mobile",value="电话号码",required=true) String mobile) {
        return smsService.sendValidateCode(mobile);
    }

    @ApiOperation(value = "验证码登录", notes = "验证码登录")
    @PostMapping("loginByValidateCode")
    public ResultVo loginByValidateCode(@ApiParam(name="mobile",value="电话号码",required=true)String mobile,
                                        @ApiParam(name="validateCode",value="短信验证号码",required=true)String validateCode) {
        return customerLoginService.loginByValidateCode(mobile, validateCode);
    }
}
