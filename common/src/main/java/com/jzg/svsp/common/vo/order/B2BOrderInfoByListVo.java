package com.jzg.svsp.common.vo.order;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: B2BOrderInfoByListVo
 * @creation: 2018/9/26 16:23
 * @notes: 列表
 */
public class B2BOrderInfoByListVo implements Serializable {

    private static final long serialVersionUID = 7419400702270027112L;

    private Integer businessType;
    private Integer buyId;
    private Integer saleId;
    private Integer orderStatus;
    private Integer payMethod;
    private Integer moneyStatus;
    private Integer carStatus;
    private Integer startNum;

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getMoneyStatus() {
        return moneyStatus;
    }

    public void setMoneyStatus(Integer moneyStatus) {
        this.moneyStatus = moneyStatus;
    }

    public Integer getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }
}
