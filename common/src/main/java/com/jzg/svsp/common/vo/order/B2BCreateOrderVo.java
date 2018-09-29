package com.jzg.svsp.common.vo.order;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: B2BCreateOrderVo
 * @creation: 2018/9/26 15:56
 * @notes: 创建订单
 */
public class B2BCreateOrderVo implements Serializable {

    private static final long serialVersionUID = 1140575108677444277L;

    private String buyId;
    private String saleId;
    private String saleName;
    private String productId;
    private String productName;
    private String orderMoney;
    private String payMoney;
    private String payMethod;
    private String modifier_id;
    private String modifier_name;

    public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getModifier_id() {
        return modifier_id;
    }

    public void setModifier_id(String modifier_id) {
        this.modifier_id = modifier_id;
    }

    public String getModifier_name() {
        return modifier_name;
    }

    public void setModifier_name(String modifier_name) {
        this.modifier_name = modifier_name;
    }
}
