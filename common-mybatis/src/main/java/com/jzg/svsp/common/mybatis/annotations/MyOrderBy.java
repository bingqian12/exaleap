package com.jzg.svsp.common.mybatis.annotations;

import java.lang.annotation.*;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/22 10:50
 * @notes:
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyOrderBy {
    String value() default "";
}
