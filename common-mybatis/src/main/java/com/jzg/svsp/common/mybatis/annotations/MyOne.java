package com.jzg.svsp.common.mybatis.annotations;

import java.lang.annotation.*;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/26 19:05
 * @notes:
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyOne {
    /**
     * 一对多关系里面 自己的关联字段
     *
     * @return
     */
    String ownField();

    /**
     * 一对一关系里面 另一个实体的查询字段
     *
     * @return
     */
    String otherField();

    /**
     * 关联的字段是不是另一个实体的主键
     * 默认false
     *
     * @return
     */
    boolean primary() default false;
}