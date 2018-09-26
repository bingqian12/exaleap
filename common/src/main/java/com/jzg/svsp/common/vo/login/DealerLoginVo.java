package com.jzg.svsp.common.vo.login;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;


@Data
public class DealerLoginVo implements BaseVo{

    long dealerId;
    String loginName;
    String password;
    int userStats;
    long mobilePhone;
    String token;

    @Override
    public String toString() {
        return "dealerLoginVo{" +
                "dealerId=" + dealerId +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userStats=" + userStats +
                ", mobilePhone=" + mobilePhone +
                ", token=" + token +
                '}';
    }

    public void setDealerId(long dealerId) {
        this.dealerId = dealerId;
    }

    public long getDealerId() {
        return dealerId;
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
