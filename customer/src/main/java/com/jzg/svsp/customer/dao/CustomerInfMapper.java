package com.jzg.svsp.customer.dao;

import com.jzg.svsp.customer.entity.CustomerInf;

public interface CustomerInfMapper {
    int deleteByPrimaryKey(Long customerInfId);

    int insert(CustomerInf record);

    int insertSelective(CustomerInf record);

    CustomerInf selectByPrimaryKey(Long customerInfId);

    int updateByPrimaryKeySelective(CustomerInf record);

    int updateByPrimaryKey(CustomerInf record);
}