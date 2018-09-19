package com.jzg.svsp.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
public class ProductApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}
