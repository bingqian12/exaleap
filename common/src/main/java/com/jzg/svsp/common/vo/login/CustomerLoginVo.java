package com.jzg.svsp.common.vo.login;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;


@Data
public class CustomerLoginVo implements BaseVo{

    long customerId;
    String loginName;
    String password;
    int userStats;
    long mobilePhone;
    String token;

    @Override
    public String toString() {
        return "CustomerLoginVo{" +
                "customerId=" + customerId +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userStats=" + userStats +
                ", mobilePhone=" + mobilePhone +
                ", token=" + token +
                '}';
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserStats() {
        return userStats;
    }

    public void setUserStats(int userStats) {
        this.userStats = userStats;
    }

    public long getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(long mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
