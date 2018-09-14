package com.jzg.svsp.common.enums;

/**
 * Created by Dara on 2017/3/2.
 * 发送短信模版编码
 */
public enum SmsTemplateCode {

    /**
     * 注册码模板
     */
    VALIDATE_CODE_TPL("SMS_33845078", "验证码模版"), RegisterTpl("SMS_33910103", "注册"), DefaultTpl("SMS_10000001", "默认模板");

    private String value;
    private String text;
    private SmsTemplateCode(String value, String text){
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
