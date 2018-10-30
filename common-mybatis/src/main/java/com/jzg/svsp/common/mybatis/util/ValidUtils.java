package com.jzg.svsp.common.mybatis.util;

import com.jzg.svsp.common.mybatis.annotations.Validate;
import com.jzg.svsp.common.util.ResultUtils;
import com.jzg.svsp.common.vo.ResultVo;
import com.jzg.svsp.common.vo.RetStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.reflections.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/22 21:05
 * @notes:
 */
@Slf4j
public class ValidUtils {
    /**
     * 校验对象
     *
     * @param obj
     * @return
     */
    public static ResultVo valid(Object obj) {
        Set<Field> fields = ReflectionUtils.getAllFields(obj.getClass(), f -> f.getAnnotation(Validate.class) != null);
        for (Field f : fields) {
            try {
                Validate annotation = f.getAnnotation(Validate.class);
                f.setAccessible(true);
                Object value = f.get(obj);
                String fieldName = StringUtils.isEmpty(annotation.field()) ? f.getName() : annotation.field();
                boolean isEmpty = value == null || StringUtils.isBlank(value.toString());
                if (annotation.notNull() && isEmpty) {
                    log.error("Field({}) can not be null..........", f.getName());
                    return ResultUtils.fail(HttpStatus.SC_BAD_REQUEST, fieldName + "不能为空!");
                }
                if (StringUtils.isNotBlank(annotation.regexp()) && !isEmpty) {
                    if (!Pattern.compile(annotation.regexp()).matcher(value.toString()).find()) {
                        log.error("Field({}) format is error..........", f.getName());
                        return ResultUtils.fail(HttpStatus.SC_BAD_REQUEST, fieldName + "格式不正确！");
                    }
                }
            } catch (IllegalAccessException e) {
                log.error("Access field({}) exception.........", f.getName(), e);
                return ResultUtils.fail(RetStatus.Exception.getValue(), "操作失败！");
            }
        }
        return ResultUtils.success(true);
    }

    /**
     * 校验对象，执行方法
     *
     * @return
     */
    public static <T, R extends Serializable> ResultVo validExec(T t, Function<T, R> function) {
        //校验参数
        ResultVo valid = valid(t);
        if (!valid.succeed()) {
            return valid;
        }
        //执行方法
        R result = function.apply(t);
        return result instanceof ResultVo ? (ResultVo) result : ResultUtils.success(result);
    }

}
