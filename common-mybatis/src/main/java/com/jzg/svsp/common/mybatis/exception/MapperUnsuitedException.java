package com.jzg.svsp.common.mybatis.exception;

/**
 * mapper类型匹配异常
 *
 * @author: wang.linqiao
 * @name: MapperUnsuitedException
 * @creation: 2018/10/22 11:35
 * @notes:
 */
public class MapperUnsuitedException extends RuntimeException {
    public MapperUnsuitedException(String msg) {
        super(msg);
    }
}
