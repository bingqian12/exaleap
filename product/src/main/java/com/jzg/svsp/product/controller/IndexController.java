package com.jzg.svsp.product.controller;


import com.alibaba.fastjson.JSON;
import com.jzg.svsp.common.vo.login.CustomerLoginVo;
import com.jzg.svsp.product.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@DefaultProperties(defaultFallback ="defaultFallback" )  // 对所有函数生效。
@Api(value = "IndexController|  一个用来测试swagger注解的控制器")
//@RequestMapping("product")
public class IndexController {

    @Autowired
    CustomerService customerService;
//    @HystrixCommand(fallbackMethod = "fallback")  //单个函数的降级函数， 个别函数可以给单独的降级提示。

    //默认超时时间， 系统默认是1秒。

    /**
     * HystrixCommand  会有依赖隔离， 隔离到一个线程以内， 不影响其他函数调用。
     * @param productId
     * @return
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"),


            @HystrixProperty(name = "circuitBreaker.enabled" , value = "true"), //开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" , value = "10"), //最近10次服务
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" , value = "60"),//最近10次服务，请求的成功率， 达到就熔断
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" , value = "10000"),// 休眠10秒后， 重新探测是否需要熔断。

    })
    @ApiOperation(value="根据商品ID 获取商品详细信息", notes="   测试  ")
    @GetMapping("/api/{productId}")
    public String info(@PathVariable("productId") Long productId){

        Long customerId = 3L;
        CustomerLoginVo customerVo = customerService.getCustomerById(customerId);

        log.info(JSON.toJSONString(customerVo));


        return "hello "+ JSON.toJSONString(customerVo);
    }



    private String fallback(Long productId){

        return "太拥挤了， 请稍后再试。";
    }

    private String defaultFallback(){

        return "默认提示： 太拥挤了， 请稍后再试。 ";
    }
}
