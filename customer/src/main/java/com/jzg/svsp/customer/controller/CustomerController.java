package com.jzg.svsp.customer.controller;

import com.alibaba.fastjson.JSONObject;
import com.jzg.svsp.common.vo.ResultVo;
import com.jzg.svsp.common.vo.login.LoginParamVo;
import com.jzg.svsp.common.vo.login.SendValidateCodeParamVo;
import com.jzg.svsp.customer.service.ICustomerLoginService;
import com.jzg.svsp.customer.service.ISmsService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

/*    @ApiOperation(value = "发送验证码", notes = "注意限制固定时间内发送验证码的个数")
    @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", required = true)
    @PostMapping("sendValidateCode")
    public ResultVo sendValidateCode(@RequestParam(value = "mobile") String mobile) {
        return smsService.sendValidateCode(mobile);
    }

    @ApiOperation(value = "验证码登录", notes = "验证码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", required = true),
            @ApiImplicitParam(name = "validateCode", value = "验证码", dataType = "String", required = true)})
    @PostMapping("loginByValidateCode")
    public ResultVo loginByValidateCode(@RequestParam(value = "mobile") String mobile, @RequestParam(value = "validateCode") String validateCode) {
        return customerLoginService.loginByValidateCode(mobile, validateCode);
    }*/

    @ApiOperation(value = "发送验证码", notes = "注意限制固定时间内发送验证码的个数")
    @PostMapping("sendValidateCode")
    public ResultVo sendValidateCode(@RequestBody SendValidateCodeParamVo body) {
        return smsService.sendValidateCode(body.getMobile());
    }


    @ApiOperation(value = "验证码登录", notes = "验证码登录")
    @PostMapping("loginByValidateCode")
    public ResultVo loginByValidateCode(@RequestBody LoginParamVo body) {
        return customerLoginService.loginByValidateCode(body.getMobile(), body.getValidateCode());
    }
}
