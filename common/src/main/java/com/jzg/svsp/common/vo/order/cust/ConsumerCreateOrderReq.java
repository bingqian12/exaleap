package com.jzg.svsp.common.vo.order.cust;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: ConsumerCreateOrderReq
 * @creation: 2018/10/22 16:23
 * @notes: 创建回传
 */
public class ConsumerCreateOrderReq implements Serializable {


    private static final long serialVersionUID = 6140798113209887777L;

    private String orderSn;

    private String createTime;

    private String validTime;

    private String status;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
