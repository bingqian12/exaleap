### 文档路径 ./common/doc

### sql 文件
>  ./common/doc/*.sql


###启动端口

_需要配置IDEA 的启动选项， 端口号不设置在代码里面， 由外部配置文件启动。_ 

```

#springboot 启动不同端口
 vm  Options:   -Dserver.port=8761
#启动不同环境配置
 Program   arguments : --spring.profiles.active=dev

```


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


###  turbine  配置 

熔断监控的url 地址
 http://127.0.0.1:9411/turbine.stream





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



### rabbitmq 安装

```

docker run -d --hostname localhost --name rabbit-management --restart=always -p 15672:15672 -p 5672:5672 rabbitmq:3.6-management-alpine


```


###编译版本
```
#编译war包
mvn clean install -Pprod  #（dev; local; test; prod）

#通过jar 文件启动服务 
java -jar ROOT.jar --spring.profiles.active=prod


#springboot 启动服务 
--spring.profiles.active=test
Program   arguments : -Dserver.port=8761

```


### 服务启动顺序

_主要要启动 config 服务， 如果不启动， 各个服务无法读取到配置文件_

* 1. eureka
* 2. config
* 3. gateway
* 4. monitor
* 5. customer
* 6. product
 
 
 
 ### docker install
 
 
 ```
 #直接yum安装，安装成功后查看版本
 yum install docker-io -y
 
 
 docker -v
 
 #启动docker
 service docker start
 
 #设置开机启动
 chkconfig docker on


```


### rabbitmq 安装
```


#直接阿里云下载的docker镜像  

docker pull  registry.cn-hangzhou.aliyuncs.com/zp-k8s/rabbitmq:3-management  

docker run -d --net host --name rabbitmq  registry.cn-hangzhou.aliyuncs.com/zp-k8s/rabbitmq:3-management

docker ps # 查找指定容器

docker exec -it '容器id' /bin/bash

#通过find 命令查找rabbit安装目录

#找到rabbitmqctl执行  修改密码

./rabbitmqctl add_user admin 111111

./rabbitmqctl set_user_tags admin administrator

```


### yml格式检查 

   [yml格式检查](http://www.yamllint.com)
   
   
### docker 安装指导
[安装指南](http://www.runoob.com/docker/centos-docker-install.html)