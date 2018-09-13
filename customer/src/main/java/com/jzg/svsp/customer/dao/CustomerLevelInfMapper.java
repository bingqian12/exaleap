package com.jzg.svsp.customer.dao;

import com.jzg.svsp.customer.entity.CustomerLevelInf;

public interface CustomerLevelInfMapper {
    int deleteByPrimaryKey(Byte customerLevel);

    int insert(CustomerLevelInf record);

    int insertSelective(CustomerLevelInf record);

    CustomerLevelInf selectByPrimaryKey(Byte customerLevel);

    int updateByPrimaryKeySelective(CustomerLevelInf record);

    int updateByPrimaryKey(CustomerLevelInf record);
}