package com.jzg.svsp.common.vo.order.cust;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: CancelOrderVo
 * @creation: 2018/11/1 14:16
 * @notes: 取消订单
 */
public class CancelOrderVo implements Serializable {

    private static final long serialVersionUID = 7835079814965953019L;

    private String orderSn;
    /**
     * 资金
     */
    private String moneyStatus;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getMoneyStatus() {
        return moneyStatus;
    }

    public void setMoneyStatus(String moneyStatus) {
        this.moneyStatus = moneyStatus;
    }
}
