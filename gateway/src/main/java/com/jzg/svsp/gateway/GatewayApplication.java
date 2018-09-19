package com.jzg.svsp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

//@SpringBootApplication
//@EnableDiscoveryClient
@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
