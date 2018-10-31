package com.jzg.svsp.common.mybatis.exception;

/**
 * 一对一的解析异常
 *
 * @author: wang.linqiao
 * @name: One2OneException
 * @creation: 2018/10/28 9:53
 * @notes:
 */
public class One2OneException extends RuntimeException {
    public One2OneException(String msg) {
        super(msg);
    }
}
