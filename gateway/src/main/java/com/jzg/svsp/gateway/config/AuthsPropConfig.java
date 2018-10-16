package com.jzg.svsp.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 读取配置文件
 */
@Component
@ConfigurationProperties(prefix="auths-props")
@Data
public class AuthsPropConfig {

    /*private List<String> apiUrls =new ArrayList<String>();
    private List<String> monitorUrls = new ArrayList<>();
    private List<String> excludeUrls =new ArrayList<String>();*/
    private Map<String,String> apiUrlMap ;
    private Map<String,String> monitorUrlMap;
    private Map<String,String> excludeUrlMap;
    private String accessToken;
    private String accessIp;
    private String authLevel;
}
