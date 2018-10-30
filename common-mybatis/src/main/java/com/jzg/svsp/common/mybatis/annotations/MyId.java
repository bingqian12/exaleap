package com.jzg.svsp.common.mybatis.annotations;

import java.lang.annotation.*;

/**
 * Mybatis主键的注解
 *
 * @author: wang.linqiao
 * @creation: 2018/10/22 10:10
 * @notes:
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyId {
    String value() default "";
}
