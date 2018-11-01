package com.jzg.svsp.common.mybatis.exception;

/**
 * 一对多的解析异常
 *
 * @author: wang.linqiao
 * @name: One2ManyException
 * @creation: 2018/10/28 9:53
 * @notes:
 */
public class One2ManyException extends RuntimeException {
    public One2ManyException(String msg) {
        super(msg);
    }
}
