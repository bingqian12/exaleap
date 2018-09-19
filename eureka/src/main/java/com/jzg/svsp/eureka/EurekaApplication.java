package com.jzg.svsp.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author JZG
 * 服务注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
}
