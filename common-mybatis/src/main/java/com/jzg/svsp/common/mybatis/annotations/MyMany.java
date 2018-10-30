package com.jzg.svsp.common.mybatis.annotations;

import java.lang.annotation.*;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/26 19:04
 * @notes:
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMany {
    /**
     * 一对多关系里面 one的关联字段
     *
     * @return
     */
    String ownField();

    /**
     * 一对多关系里面 many的查询字段
     *
     * @return
     */
    String otherField();
}