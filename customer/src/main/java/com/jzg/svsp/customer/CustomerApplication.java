package com.jzg.svsp.customer;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@MapperScan("com.jzg.svsp.customer.dao")
@SpringCloudApplication
public class CustomerApplication {

	public static void main(String[] args) {


		SpringApplication.run(CustomerApplication.class, args);
	}
}
