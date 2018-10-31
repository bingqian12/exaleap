package com.jzg.svsp.common.aspect;

import com.alibaba.fastjson.JSON;
import com.jzg.svsp.common.util.ValidUtils;
import com.jzg.svsp.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/30 11:29
 * @notes:
 */
@Aspect
@Component
@Slf4j
@ConditionalOnExpression("'${valid.enable:false}'=='true'")
public class ValidAspect {
    /**
     * 切点
     * 所有 com.jzg 包及其子包下以 Controller结尾的类中包含 @RequestBody 的参数的方法
     */
    @Pointcut("execution(* com.jzg..*.*Controller.*(..,@org.springframework.web.bind.annotation.RequestBody (*),..))")
    public void point() {
    }

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("{}参数校验：{}", joinPoint.getSignature().toString(), JSON.toJSONString(joinPoint.getArgs()));
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Parameter[] parameters = method.getParameters();
        Object[] args = joinPoint.getArgs();
        /*仅校验带@RequestBody的参数*/
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].getAnnotation(RequestBody.class) != null) {
                ResultVo valid = ValidUtils.valid(args[i]);
                if (!valid.succeed()) {
                    log.error("参数校验不通过:{}", valid.getMsg());
                    return valid;
                }
            }
        }
        return joinPoint.proceed();
    }

}
