package com.jzg.svsp.common.vo.login;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;


@Data
public class CustomerLoginVo implements BaseVo{

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
