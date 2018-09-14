package com.jzg.svsp.customer.entity;

import java.util.Date;

public class CustomerLoginLog {
    private Long loginId;

    private Long customerId;

    private Date loginTime;

    private Integer loginIp;

    private Byte loginType;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(Integer loginIp) {
        this.loginIp = loginIp;
    }

    public Byte getLoginType() {
        return loginType;
    }

    public void setLoginType(Byte loginType) {
        this.loginType = loginType;
    }
}