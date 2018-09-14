package com.jzg.svsp.common.vo;


/**
 * RetStatus 返回状态枚举
 * Ok:正常返回
 * Exception：内部异常，并返回异常信息
 * Failure：调用失败，返回失败信息
 * InValid：非法调用，sign验证失败
 * NoLogin：未登录
 * NoAuth：无权限
 */
public enum RetStatus {

    /**
     *  Ok:正常返回
     */
    Ok(200),
    /**
     * Exception：内部异常，并返回异常信息
     */
    Failure(202),
    /**
     * InValid：非法调用，sign验证失败
     */
    InValid(204),
    /**
     * 内部异常，并返回异常信息
     */
    Exception(500),
    /**
     * NoLogin：未登录
     */
    NoLogin(700),
    /**
     * 无权限
     */
    NoAuth(701);

    private final int value;

    private RetStatus(int value) {
        this.value = value;
    }

    /**
     * Get the integer value of this enum value
     */
    public int getValue() {
        return value;
    }


}