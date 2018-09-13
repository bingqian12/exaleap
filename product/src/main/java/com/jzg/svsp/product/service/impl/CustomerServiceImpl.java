package com.jzg.svsp.product.service.impl;

import com.jzg.svsp.common.vo.CustomerLoginVo;
import com.jzg.svsp.product.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerLoginVo getCustomerById(Long customerId) {
        log.info("调用{}失败---------- ssss     ","getCustomerById");
        return  null ;
    }
}
