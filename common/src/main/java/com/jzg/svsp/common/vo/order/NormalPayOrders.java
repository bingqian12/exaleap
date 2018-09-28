package com.jzg.svsp.common.vo.order;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: NormalPayOrders
 * @creation: 2018/9/28 18:15
 * @notes: 订单详情接口参数
 */
public class NormalPayOrders implements Serializable {

    private static final long serialVersionUID = -5418256148230339759L;

    private String orderSn;
    private Integer businessType;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }
}
