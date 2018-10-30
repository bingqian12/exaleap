package com.jzg.svsp.common.mybatis.annotations;

import java.lang.annotation.*;

/**
 * Mybatis表名的注解
 *
 * @author: wang.linqiao
 * @creation: 2018/10/22 10:07
 * @notes:
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTable {
    String value() default "";
}
