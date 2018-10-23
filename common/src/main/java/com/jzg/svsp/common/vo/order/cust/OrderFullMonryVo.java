package com.jzg.svsp.common.vo.order.cust;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: OrderFullMonryVo
 * @creation: 2018/10/22 18:03
 * @notes: 付全款
 */
public class OrderFullMonryVo implements Serializable {


    private static final long serialVersionUID = -8864002102818531373L;

    private String orderSn;
    private String payMethod;
    private String tailMoney;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getTailMoney() {
        return tailMoney;
    }

    public void setTailMoney(String tailMoney) {
        this.tailMoney = tailMoney;
    }
}
