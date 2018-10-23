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

    private String valiTime;


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

    public String getValiTime() {
        return valiTime;
    }

    public void setValiTime(String valiTime) {
        this.valiTime = valiTime;
    }
}
