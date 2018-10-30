package com.jzg.svsp.common.vo.order.dealer;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: YuGenHai
 * @name: B2BOrderInfoByListVo
 * @creation: 2018/9/26 16:23
 * @notes: B2B列表页条件
 */
public class DealerSearchByListVo implements Serializable {

    private static final long serialVersionUID = 7419400702270027112L;

    /**
     * 当前ID
     */
    private Long dealerId;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 查询条件展示门店名称列表
     */
    private String storesName;

    /**
     * 查询条件展示销售人员名字
     */
    private String saleName;


    /**
     * 创建时间
     */
    private String createBeTime;
    private String createEnTime;

    /**
     * 付款时间
     */
    private String payBeTime;
    private String payEnTime;


    /**
     * 当前页码
     */
    private Integer pageNo;
    /**
     * 每页条数
     */
    private Integer pageSize;


    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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

    public String getCreateBeTime() {
        return createBeTime;
    }

    public void setCreateBeTime(String createBeTime) {
        this.createBeTime = createBeTime;
    }

    public String getCreateEnTime() {
        return createEnTime;
    }

    public void setCreateEnTime(String createEnTime) {
        this.createEnTime = createEnTime;
    }

    public String getPayBeTime() {
        return payBeTime;
    }

    public void setPayBeTime(String payBeTime) {
        this.payBeTime = payBeTime;
    }

    public String getPayEnTime() {
        return payEnTime;
    }

    public void setPayEnTime(String payEnTime) {
        this.payEnTime = payEnTime;
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
