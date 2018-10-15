package com.jzg.svsp.common.vo.order.feignclient;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: ProductInfo
 * @creation: 2018/10/12 18:26
 * @notes: 车辆信息
 */
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 8593902920800587559L;

    /**
     * 入参productId
     */

    private String productName;
    private String vin;
    private String url;
    private String carLicence;
    private String runMileage;
    private String orderMoney;

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

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }
}
