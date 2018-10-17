package com.jzg.svsp.common.vo.order.dealer;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: CreateOrderVoByC
 * @creation: 2018/10/15 11:43
 * @notes: C端创建订单request
 */
public class CreateOrderVoByB implements Serializable {


    private static final long serialVersionUID = 2504646064342221371L;

    private String productId;
    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 店铺ID
     */
    private String storesId;

    /**
     * 销售人员
     */
    private String saleName;
    /**
     * 商家ID
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
     * 车辆C端价格
     */
    private String toBPrice;

    /**
     * 车辆B端价格
     */
    private String toCPrice;
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

    /**
     * 入参productId
     */

    private String productName;
    private String vin;
    private String url;
    private String carLicence;
    private String runMileage;

    /**
     * 尾款
     */
    private String tailMoney;

    /**
     * 店铺名称
     */
    private String storesName;

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

    public String getStoresId() {
        return storesId;
    }

    public void setStoresId(String storesId) {
        this.storesId = storesId;
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

    public String getToBPrice() {
        return toBPrice;
    }

    public void setToBPrice(String toBPrice) {
        this.toBPrice = toBPrice;
    }

    public String getToCPrice() {
        return toCPrice;
    }

    public void setToCPrice(String toCPrice) {
        this.toCPrice = toCPrice;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCarLicence() {
        return carLicence;
    }

    public void setCarLicence(String carLicence) {
        this.carLicence = carLicence;
    }

    public String getRunMileage() {
        return runMileage;
    }

    public void setRunMileage(String runMileage) {
        this.runMileage = runMileage;
    }

    public String getTailMoney() {
        return tailMoney;
    }

    public void setTailMoney(String tailMoney) {
        this.tailMoney = tailMoney;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }
}
