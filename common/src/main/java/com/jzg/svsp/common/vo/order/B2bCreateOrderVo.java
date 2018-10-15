package com.jzg.svsp.common.vo.order;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: B2bCreateOrderVo
 * @creation: 2018/9/26 15:56
 * @notes: B2B创建订单
 */
public class B2bCreateOrderVo implements Serializable {

    private static final long serialVersionUID = 1140575108677444277L;

    int aaa;
    private String productId;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 销售人员
     */
    private String saleName;
    /**
     * 当前用户角色
     */
    private String dealerId;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 定金
     */
    private String payment;
    /**
     * 成交价
     */
    private String payMoney;
    /**
     * 定价（车市场定价）
     */
    private String orderMoney;
    /**
     * 保险公司
     */
    private String insuranceCompany;
    /**
     * 买方ID
     */
    private String buyId;
    /**
     * 买家姓名
     */
    private String buyName;
    /**
     * 买家电话
     */
    private String phone;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId;
    }

    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
