/*
package com.jzg.svsp.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * 整合Swagger文档
 * @author Nicolas Cage
 * @date 20181023
 *//*

@Component
@Primary
@Slf4j
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        log.info("进入DocumentationConfig.get()方法");
        List resources = new ArrayList<>();
        resources.add(swaggerResource("订单系统", "/order/v2/api-docs", "2.0"));
        resources.add(swaggerResource("用户系统", "/user/v2/api-docs", "2.0"));
        resources.add(swaggerResource("服务系统", "/service/v2/api-docs", "2.0"));
        resources.add(swaggerResource("车商系统", "/dealer/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
*/
