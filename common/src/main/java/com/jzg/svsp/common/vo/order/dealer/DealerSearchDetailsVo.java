package com.jzg.svsp.common.vo.order.dealer;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: B2bOrderDetailsVo
 * @creation: 2018/10/24 14:22
 * @notes: 订单详情
 */
public class DealerSearchDetailsVo implements Serializable {

    private static final long serialVersionUID = 1613936426578572667L;

    private String currentId;
    private String orderSn;

    public String getCurrentId() {
        return currentId;
    }

    public void setCurrentId(String currentId) {
        this.currentId = currentId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
}
