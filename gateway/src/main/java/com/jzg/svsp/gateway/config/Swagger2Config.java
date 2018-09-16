package com.jzg.svsp.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-04-18
 * Time: 14:55
 */
@Configuration
@EnableSwagger2
@Slf4j
public class Swagger2Config {
    @Value("${config-name}")
    private  String configName ;

    @Bean
    public Docket createRestApi() {
        log.info("SpringCloudApplication start . \n-----------------------------------------config file name ==> [{}]\n " , configName);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("网关说明文档")
                .description("接口说明文档")
                .termsOfServiceUrl("")
                .contact(new Contact("dikers","xxx@foxmail.com","xxx@foxmail.com"))
                .version("1.0")
                .build();
    }
}
