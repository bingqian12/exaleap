package com.jzg.svsp.common.vo.order.cust;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: ConsumerCreateOrderVo
 * @creation: 2018/10/15 11:43
 * @notes: C端创建订单request
 */
public class ConsumerCreateOrderVo implements Serializable {


    private static final long serialVersionUID = 2504646064342221371L;
    /**
     * 车辆ID
     */
    private String productId;
    /**
     * 订单类型
     */
    private String orderType;
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
     * 店铺ID
     */
    private String storesId;
    /**
     * 商家ID
     */
    private String dealerId;
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
    private String toCPrice;
    /**
     * 车辆B端价格
     */
    private String toBPrice;

    /**
     * 车辆信息
     */
    private String productName;
    private String vin;
    private String url;
    private String carLicence;
    private String runMileage;
    private String regDate;
    /**
     * 店铺名称
     */
    private String storesName;
    /**
     * 预约单号
     */
    private String bookNumber;

    /**
     * 销售人员
     */
    private String saleName;

    /**
     * 保险公司
     */
    private String insuranceCompany;


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

    public String getStoresId() {
        return storesId;
    }

    public void setStoresId(String storesId) {
        this.storesId = storesId;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
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

    public String getToCPrice() {
        return toCPrice;
    }

    public void setToCPrice(String toCPrice) {
        this.toCPrice = toCPrice;
    }

    public String getToBPrice() {
        return toBPrice;
    }

    public void setToBPrice(String toBPrice) {
        this.toBPrice = toBPrice;
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
}
