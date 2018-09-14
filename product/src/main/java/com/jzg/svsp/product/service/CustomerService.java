package com.jzg.svsp.product.service;

import com.jzg.svsp.common.vo.login.CustomerLoginVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//,fallback = CustomerServiceImpl.class
@FeignClient(name = "customer")
public interface CustomerService {
    /**
     * 测试代码
     * @param customerId
     * @return
     */
    @GetMapping("/getCustomerById/{customerId}")
    public CustomerLoginVo getCustomerById(@PathVariable("customerId") Long customerId);
}
