package com.jzg.svsp.customer.dao;

import com.jzg.svsp.customer.entity.CustomerLogin;

public interface CustomerLoginMapper {
    int deleteByPrimaryKey(Long customerId);

    int insert(CustomerLogin record);

    int insertSelective(CustomerLogin record);

    CustomerLogin selectByPrimaryKey(Long customerId);

    int updateByPrimaryKeySelective(CustomerLogin record);

    int updateByPrimaryKey(CustomerLogin record);
}