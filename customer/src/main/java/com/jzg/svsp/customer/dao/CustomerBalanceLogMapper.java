package com.jzg.svsp.customer.dao;

import com.jzg.svsp.customer.entity.CustomerBalanceLog;

public interface CustomerBalanceLogMapper   {
    int deleteByPrimaryKey(Long balanceId);

    int insert(CustomerBalanceLog record);

    int insertSelective(CustomerBalanceLog record);

    CustomerBalanceLog selectByPrimaryKey(Long balanceId);

    int updateByPrimaryKeySelective(CustomerBalanceLog record);

    int updateByPrimaryKey(CustomerBalanceLog record);
}