package com.jzg.svsp.gateway.config;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 读取配置文件
 */
@Component
@ConfigurationProperties(prefix="auth-props")
@Data
public class AuthPropConfig {

    private Map<String,Integer> apiUrlMap ;
    private List<String> excludeUrls ;
    private String accessToken;
    private String accessIp;
    private String authLevel;

}
