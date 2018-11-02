package com.jzg.svsp.common.swagger;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: wang.linqiao
 * @creation: 2018/11/1 20:12
 * @notes:
 */
@EnableSwagger2
@Slf4j
@Configuration
@ConditionalOnExpression("'${swagger.enable:false}' == 'true'")
public class SwaggerConfig {
    @Value("${config-name}")
    private String configName;
    @Value("${spring.application.name}")
    private String appName;

    @Bean
    public Docket createRestApi() {
        //设置一个唯一的名称， springboot 启动时，会打印这个名称， 用来调试是否用对了配置文件。
        //config-name: manager_local
        log.info("SpringCloudApplication start . \n-----------------------------------------config file name ==> [{}]\n ", configName);
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        /*配置公共header参数*/
        if (SwaggerParamConfig.hasParam()) {
            List<Parameter> parameters = SwaggerParamConfig.getParams().stream()
                    .map(this::buildParameter)
                    .collect(Collectors.toList());
            docket.globalOperationParameters(parameters);
        }

        return docket.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(StringUtils.isNotBlank(appName) ? appName : "" + "接口文档")
                .description("<a href=\"/api\" target=\"_blank\">Feign Client说明<a>")
                .termsOfServiceUrl("")
                .contact(new Contact("JZG", "http://www.jingzhengu.com", "http://www.jingzhengu.com"))
                .version("0.0.1")
                .build();
    }

    private Parameter buildParameter(String name) {
        return new ParameterBuilder().name(name).description(name)
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build();

    }
}
