package com.jzg.svsp.common.vo.vehicle;

import com.jzg.svsp.common.vo.BaseVo;

import java.math.BigDecimal;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 15:10 on 2018/9/25.
 */
public class VehicleSourceParam implements BaseVo{

    /**
     * 客户ID
     */
    private Long custId;
    /**
     * 车源ID
     */
    private Long vehicleId;
    /**
     * 卖给车商价格
     */
    private BigDecimal toBPrice;
    /**
     * 卖给个人价格
     */
    private BigDecimal toCPrice;
    /**
     * 卖给车商定金
     */
    private BigDecimal toBDeposit;
    /**
     * 卖给个人定金
     */
    private BigDecimal toCDeposit;
    /**
     * 车源状态 0 下架 1 上架
     */
    private Integer saleStatus;
    /**
     * 当前页码
     */
    private Integer pageNo;
    /**
     * 每页条数
     */
    private Integer pageSize;



    /**
     * 获取 车源ID
     *
     * @return vehicleId 车源ID
     */
    public Long getVehicleId() {
        return this.vehicleId;
    }

    /**
     * 设置 车源ID
     *
     * @param vehicleId 车源ID
     */
    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * 获取 卖给车商价格
     *
     * @return toBPrice 卖给车商价格
     */
    public BigDecimal getToBPrice() {
        return this.toBPrice;
    }

    /**
     * 设置 卖给车商价格
     *
     * @param toBPrice 卖给车商价格
     */
    public void setToBPrice(BigDecimal toBPrice) {
        this.toBPrice = toBPrice;
    }

    /**
     * 获取 卖给个人价格
     *
     * @return toCPrice 卖给个人价格
     */
    public BigDecimal getToCPrice() {
        return this.toCPrice;
    }

    /**
     * 设置 卖给个人价格
     *
     * @param toCPrice 卖给个人价格
     */
    public void setToCPrice(BigDecimal toCPrice) {
        this.toCPrice = toCPrice;
    }

    /**
     * 获取 车源状态 0 下架 1 上架
     *
     * @return saleStatus 车源状态 0 下架 1 上架
     */
    public Integer getSaleStatus() {
        return this.saleStatus;
    }

    /**
     * 设置 车源状态 0 下架 1 上架
     *
     * @param saleStatus 车源状态 0 下架 1 上架
     */
    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }


    /**
     * 获取 卖给车商定金
     *
     * @return toBDeposit 卖给车商定金
     */
    public BigDecimal getToBDeposit() {
        return this.toBDeposit;
    }

    /**
     * 设置 卖给车商定金
     *
     * @param toBDeposit 卖给车商定金
     */
    public void setToBDeposit(BigDecimal toBDeposit) {
        this.toBDeposit = toBDeposit;
    }

    /**
     * 获取 卖给个人定金
     *
     * @return toCDeposit 卖给个人定金
     */
    public BigDecimal getToCDeposit() {
        return this.toCDeposit;
    }

    /**
     * 设置 卖给个人定金
     *
     * @param toCDeposit 卖给个人定金
     */
    public void setToCDeposit(BigDecimal toCDeposit) {
        this.toCDeposit = toCDeposit;
    }

    /**
     * 获取 客户ID
     *
     * @return custId 客户ID
     */
    public Long getCustId() {
        return this.custId;
    }

    /**
     * 设置 客户ID
     *
     * @param custId 客户ID
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    /**
     * 获取 当前页码
     *
     * @return pageNo 当前页码
     */
    public Integer getPageNo() {
        return this.pageNo;
    }

    /**
     * 设置 当前页码
     *
     * @param pageNo 当前页码
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取 每页条数
     *
     * @return pageSize 每页条数
     */
    public Integer getPageSize() {
        return this.pageSize;
    }

    /**
     * 设置 每页条数
     *
     * @param pageSize 每页条数
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
