package com.jzg.svsp.common.vo.order.dealer;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: DealerCancelOrderVo
 * @creation: 2018/10/26 10:15
 * @notes:  B端取消订单
 */
public class DealerCancelOrderVo implements Serializable {

    private static final long serialVersionUID = 1690385382029990573L;

    private String orderSn;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
}
