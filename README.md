### 文档路径 ./common/doc

### sql 文件
>  ./common/doc/*.sql


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



