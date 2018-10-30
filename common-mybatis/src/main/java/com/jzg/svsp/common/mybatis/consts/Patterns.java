package com.jzg.svsp.common.mybatis.consts;

/**
 * 常用正则
 *
 * @author: wang.linqiao
 * @creation: 2018/10/24 16:38
 * @notes:
 */
public class Patterns {
    /**
     * 身份证
     */
    public static final String SSN = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
    /**
     * 数值
     */
    public static final String NUMBER = "^\\-?\\d+.?\\d+$";
    /**
     * 纯数字
     */
    public static final String DIGITAL = "^\\d+$";
    /**
     * 手机号
     */
    public static final String MOBILE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
    /**
     * Email
     */
    public static final String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

}
