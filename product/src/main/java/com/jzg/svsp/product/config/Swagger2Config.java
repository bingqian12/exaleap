package com.jzg.svsp.product.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
@Slf4j
//@EnableWebMvc //必须存在
//@ComponentScan(basePackages = {"com.jzg.svsp.customer.controller"}) //必须存在 扫描
public class Swagger2Config {
    @Value("${config-name}")
    private  String configName ;

    @Bean
    public Docket createRestApi() {
        log.info("SpringCloudApplication start . \n-----------------------------------------config file name ==> [{}]\n " , configName);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jzg.svsp.product"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Product 文档")
                .description("Product 接口说明文档")
                .termsOfServiceUrl("")
                .contact(new Contact("JZG","http://www.jingzhengu.com","http://www.jingzhengu.com"))
                .version("0.0.1")
                .build();
    }
}
