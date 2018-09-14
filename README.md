### 文档路径 ./common/doc

### sql 文件
>  ./common/doc/*.sql


### 权限控制
> 需要控制的权限  添加到 zuul application.yml 


``` 
#需要权限控制的url
auth-props:
  testurl: abcdedf
  urls:
    - /customer/api      #以这些开头的会验证token
    - /product/api

```


```



```




### 启动zipkin 链路追踪
1. 先启动docker 服务

``` 
docker run -d -p 9411:9411 openzipkin/zipkin
```

2. pom 文件加入 zipkin + sleuth
```

		<!--链路追踪 包含 zipkin sleuth -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-zipkin</artifactId>
		</dependency>
		<!--链路追踪 end -->

```

3. 服务里面加入发送代码
```
  zipkin:
    base-url: http://127.0.0.1:9411/    #请求地址
  sleuth:
    sampler:1               #采样率  正式环境 设置0.1  

```
------------

### 熔断降级 HystrixDashboard
添加pom 依赖

``` 

		<!-- hystrix start -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-netflix-hystrix-dashboard</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<!-- hystrix end -->

```
添加注解 @EnableHystrixDashboard
```

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
+@EnableHystrixDashboard
@MapperScan("com.jzg.svsp.customer.dao")
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}



```





###  @EnableFeignClients

> 调用方， 需要加@EnableFeignClients 注解
```依赖的jar
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>
```


```调用方

@FeignClient(name = "customer")
public interface CustomerService {
    @GetMapping("/getCustomerById/{customerId}")
    public String getCustomerById(@PathVariable("customerId") Long customerId);
}


```


```被调用方

    @GetMapping("getCustomerById/{customerId}")
    public String getCustomerById(@PathVariable("customerId") Long customerId){
        return "customerId_"+customerId;
    }


```



