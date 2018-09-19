package com.jzg.svsp.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
//import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
//@EnableZipkinServer

public class MonitorApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MonitorApplication.class, args);
	}
}
