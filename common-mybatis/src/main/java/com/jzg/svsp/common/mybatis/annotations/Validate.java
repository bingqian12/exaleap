package com.jzg.svsp.common.mybatis.annotations;

import java.lang.annotation.*;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/22 21:03
 * @notes:
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    /**
     * 不为空
     *
     * @return
     */
    boolean notNull() default true;

    /**
     * 正则
     *
     * @return
     */
    String regexp() default "";

    /**
     * 提示字段信息
     */
    String field() default "";

}
