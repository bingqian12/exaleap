package com.jzg.svsp.common.mybatis.context;

import com.jzg.svsp.common.mybatis.service.BaseService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/26 19:34
 * @notes:
 */
@Component
public class MybatisContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MybatisContext.applicationContext = applicationContext;
    }

    public static BaseService getBaseServiceByEntityClass(Class<?> entityClass) {
        Map<String, BaseService> serviceMap = applicationContext.getBeansOfType(BaseService.class);
        for (BaseService baseService : serviceMap.values()) {
            if (entityClass.equals(baseService.getEntityClass())) {
                return baseService;
            }
        }
        return null;
    }
}
