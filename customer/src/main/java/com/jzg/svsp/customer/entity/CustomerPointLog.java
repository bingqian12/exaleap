package com.jzg.svsp.customer.entity;

import java.util.Date;

public class CustomerPointLog {
    private Integer pointId;

    private Long customerId;

    private Byte source;

    private Integer referNumber;

    private Short changePoint;

    private Date createTime;

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Integer getReferNumber() {
        return referNumber;
    }

    public void setReferNumber(Integer referNumber) {
        this.referNumber = referNumber;
    }

    public Short getChangePoint() {
        return changePoint;
    }

    public void setChangePoint(Short changePoint) {
        this.changePoint = changePoint;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}