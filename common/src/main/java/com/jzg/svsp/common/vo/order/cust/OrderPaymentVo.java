package com.jzg.svsp.common.vo.order.cust;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: OrderPaymentVo
 * @creation: 2018/10/15 18:14
 * @notes:  定金VO
 */
public class OrderPaymentVo implements Serializable {


    private static final long serialVersionUID = 6102903468208586073L;

    private String orderSn;
    private String payment;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
