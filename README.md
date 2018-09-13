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

