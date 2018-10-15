package com.jzg.svsp.common.vo.order.feignclient;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: DealerInfo
 * @creation: 2018/10/12 18:38
 * @notes: 商户信息
 */
public class DealerInfo implements Serializable {

    private static final long serialVersionUID = 5569597269712769527L;

    /**
     * 入参 dealerId 当前用户ID
     */

    /**
     * 商家ID
     */
    private String saleId;
    /**
     * 商家名
     */
    private String storesName;
    /**
     * 销售人员
     */
    private String saleName;


    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }
}
