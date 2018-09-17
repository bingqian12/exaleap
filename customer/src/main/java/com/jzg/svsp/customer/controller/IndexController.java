package com.jzg.svsp.customer.controller;


import com.jzg.svsp.common.vo.login.CustomerLoginVo;
import com.jzg.svsp.customer.entity.CustomerLogin;
import com.jzg.svsp.customer.service.ICustomerLoginService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@DefaultProperties(defaultFallback ="defaultFallback" )  // 对所有函数生效。
@Api(value = "IndexController|  一个用来测试swagger注解的控制器")
//@RequestMapping("customer")
public class IndexController {


    @Autowired
    ICustomerLoginService customerLoginService ;
    @HystrixCommand(   commandProperties = {

            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),


            @HystrixProperty(name = "circuitBreaker.enabled" , value = "true"), //开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" , value = "10"), //最近10次服务
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" , value = "60"),//最近10次服务，请求的失败率， 达到就熔断
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" , value = "10000"),// 休眠10秒后， 重新探测是否需要熔断。

    })
    @ApiOperation(value="根据用户编号获取用户详细信息", notes="test: 仅1和2有正确返回")
    @GetMapping("getCustomerById/{customerId}")
    public CustomerLoginVo getCustomerById(@PathVariable("customerId") Long customerId) {

        if(customerId %2 ==0) {
//                Thread.sleep(1100);
           throw  new RuntimeException("测试异常");

        }
        CustomerLoginVo customerVO = new CustomerLoginVo();
        CustomerLogin customerLogin = customerLoginService.createCustomer("13811112221");
        if(customerLogin == null ){

            customerVO.setCustomerId(111L);
            customerVO.setLoginName("我是默认的用户，");
            customerVO.setMobilePhone(234234234L);
            customerVO.setPassword("md5");
            customerVO.setUserStats(1);

        }else {

            customerVO.setCustomerId(customerLogin.getCustomerId());
            customerVO.setPassword(customerLogin.getPassword());
            customerVO.setMobilePhone(customerLogin.getMobilePhone());
            customerVO.setLoginName(customerLogin.getLoginName());
            customerVO.setPassword(customerLogin.getPassword());
            customerVO.setUserStats(customerLogin.getUserStats());


        }



        return customerVO;
    }


    private CustomerLoginVo defaultFallback(){
        CustomerLoginVo customerVO = new CustomerLoginVo();
        customerVO.setCustomerId(111L);
        customerVO.setLoginName("我是默认的用户， 发生错误了");
        customerVO.setMobilePhone(234234234L);
        customerVO.setPassword("md5");
        customerVO.setUserStats(1);

        return customerVO;
    }
}
