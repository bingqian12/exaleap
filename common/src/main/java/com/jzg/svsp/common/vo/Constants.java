package com.jzg.svsp.common.vo;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 13:43 on 2018/9/14.
 */
public class Constants {

    /**
     * 短信验证码前缀
     */
    public static final String VALIDATE_CODE_PREFIX = "VALIDATE_CODE_PREFIX_";

    /**
     * 短信验证码有效期
     */
    public static final Integer VALIDATE_CODE_EFFECTIVE_TIME = 60 * 10;

    /**
     * TOKEN前缀
     */
    public static final String TOKEN_PREFIX = "TOKEN_PREFIX_";


    /**
     * C端客户TOKEN前缀
     */
    public static final String TOKEN_CUSTOMER_PREFIX = "TOKEN_CUSTOMER_PREFIX_";

    /**
     * B端客户TOKEN前缀
     */
    public static final String TOKEN_DEALER_PREFIX = "TOKEN_DEALER_PREFIX_";

    /**
     * TOKEN有效期
     */
    public static final Integer TOKEN_EFFECTIVE_TIME = 3600 * 24 * 7;

}
