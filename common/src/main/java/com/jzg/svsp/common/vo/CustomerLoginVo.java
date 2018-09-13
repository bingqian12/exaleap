package com.jzg.svsp.common.vo;

import lombok.Data;


@Data
public class CustomerLoginVo {

    long customerId;
    String loginName;
    String password;
    int userStats;
    long mobilePhone ;

    @Override
    public String toString() {
        return "CustomerLoginVo{" +
                "customerId=" + customerId +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userStats=" + userStats +
                ", mobilePhone=" + mobilePhone +
                '}';
    }
}
