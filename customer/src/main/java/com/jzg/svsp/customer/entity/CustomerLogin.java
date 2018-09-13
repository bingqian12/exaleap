package com.jzg.svsp.customer.entity;

import java.util.Date;

public class CustomerLogin {
    private Long customerId;

    private String loginName;

    private String password;

    private Byte userStats;

    private Date modifiedTime;

    private Long mobilePhone;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getUserStats() {
        return userStats;
    }

    public void setUserStats(Byte userStats) {
        this.userStats = userStats;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Long mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}