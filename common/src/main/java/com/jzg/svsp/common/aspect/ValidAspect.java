package com.jzg.svsp.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/30 11:29
 * @notes:
 */
@Aspect
@Component
@Slf4j
public class ValidAspect {
    /**
     * 切点
     */
    @Pointcut("@annotation(com.jzg.svsp.common.annotations.Validate)")
    public void point() {
    }

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("*********参数校验***********");
        Object obj = joinPoint.proceed();
        return obj;
    }

}
