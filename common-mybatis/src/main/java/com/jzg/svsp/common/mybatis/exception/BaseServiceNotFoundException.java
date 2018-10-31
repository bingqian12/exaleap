package com.jzg.svsp.common.mybatis.exception;

/**
 * 一对一一对多的，另外一个实体的service找不到的异常
 *
 * @author: wang.linqiao
 * @name: BaseServiceNotFoundException
 * @creation: 2018/10/28 9:54
 * @notes:
 */
public class BaseServiceNotFoundException extends RuntimeException {

    public BaseServiceNotFoundException(String msg) {
        super(msg);
    }
}
