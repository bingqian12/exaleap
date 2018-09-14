package com.jzg.svsp.customer.dao;

import com.jzg.svsp.customer.entity.CustomerLoginLog;

public interface CustomerLoginLogMapper {
    int deleteByPrimaryKey(Long loginId);

    int insert(CustomerLoginLog record);

    int insertSelective(CustomerLoginLog record);

    CustomerLoginLog selectByPrimaryKey(Long loginId);

    int updateByPrimaryKeySelective(CustomerLoginLog record);

    int updateByPrimaryKey(CustomerLoginLog record);
}