package com.jzg.svsp.common.mybatis.annotations;

import java.lang.annotation.*;

/**
 * Mybatis列名的注解
 *
 * @author: wang.linqiao
 * @creation: 2018/10/22 10:09
 * @notes:
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyColumn {
    /**
     * 列名
     *
     * @return
     */
    String value() default "";

    /**
     * 模糊匹配查询是否精确查找，默认false
     *
     * @return
     */
    boolean accuracy() default false;
}
