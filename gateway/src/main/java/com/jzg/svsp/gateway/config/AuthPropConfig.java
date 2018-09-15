package com.jzg.svsp.gateway.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 读取配置文件
 */
@Component
@ConfigurationProperties(prefix="auth-props")
@Data
public class AuthPropConfig {

    private List<String> apiUrls =new ArrayList<String>();
    private List<String> monitorUrls = new ArrayList<>();
    private String accessToken;
    private String accessIp;




}
