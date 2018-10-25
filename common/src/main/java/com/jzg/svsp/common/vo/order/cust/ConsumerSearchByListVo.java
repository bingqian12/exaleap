package com.jzg.svsp.common.vo.order.cust;

import java.io.Serializable;

/**
 * @author: YuGenHai
 * @name: ConsumerSearchByListVo
 * @creation: 2018/10/24 20:28
 * @notes: C端列表条件
 */
public class ConsumerSearchByListVo implements Serializable {

    private static final long serialVersionUID = -2629268063399922222L;

    /**
     * 买家
     */
    private Integer buyId;

    /**
     * 状态码
     * 0全部
     * 1:待付定金
     * 2:已付定金，7:待付尾款 ，5:待支付首付,6:已付首付,
     * 3:已付全款，8:已付尾款
     * 4:待退定金,4:已退定金
     */
    private Integer statusCode;

    /**
     * 当前页码
     */
    private Integer pageNo;
    /**
     * 每页条数
     */
    private Integer pageSize;


    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
