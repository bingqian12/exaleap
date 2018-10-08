package com.jzg.svsp.common.vo.vehicle;

import com.jzg.svsp.common.vo.BaseVo;

import java.math.BigDecimal;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:10 on 2018/9/25.
 */
public class VehicleInfoParam implements BaseVo {
    /**
     * 搜索参数
     */
    private String searchParam;
    /**
     * 客户ID
     */
    private String customerId;
    /**
     * 品牌  模糊搜索例如 宝马
     */
    private String makeName;
    /**
     * 车系  模糊搜索例如 3系
     */
    private String modelName;
    /**
     * 车型  模糊搜索例如
     */
    private String styleName;
    /**
     * 品牌Id
     */
    private Integer makeId;
    /**
     * 车系Id
     */
    private Integer modelId;
    /**
     * 车型Id
     */
    private Integer styleId;
    /**
     * vin码
     */
    private String vinCode;
    /**
     * 车辆状态
     */
    private Integer vehicleStatus;

    /**
     * 排序类型  1 在库天数最短 2 在库天数最长 3 标价最低 4 标价最高 5 车龄最短 6 里程最少
     */
    private Integer sortType;
    /**
     * 上牌时间
     */
    private String regDate;
    /**
     * 标价开始
     */
    private BigDecimal saleStartPrice;
    /**
     * 标价结束
     */
    private BigDecimal saleEndPrice;
    /**
     * 里程开始
     */
    private Integer mileageStart;
    /**
     * 里程结束
     */
    private Integer mileageEnd;
    /**
     * 车龄开始
     */
    private Integer carAgeStart;
    /**
     * 车龄结束
     */
    private Integer carAgeEnd;
    /**
     * 变速箱
     */
    private Integer variableBox;
    /**
     * 车系级别
     */
    private Integer modelLevel;
    /**
     * 排放标准
     */
    private Integer emissionStandard;
    /**
     * 颜色
     */
    private Integer color;
    /**
     * 当前页面
     */
    private Integer pageNo = 1;
    /**
     * 每页的数量
     */
    private Integer pageSize = 10;



    /**
     * 获取 品牌  模糊搜索例如 宝马
     *
     * @return makeName 品牌  模糊搜索例如 宝马
     */
    public String getMakeName() {
        return this.makeName;
    }

    /**
     * 设置 品牌  模糊搜索例如 宝马
     *
     * @param makeName 品牌  模糊搜索例如 宝马
     */
    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    /**
     * 获取 车系  模糊搜索例如 3系
     *
     * @return modelName 车系  模糊搜索例如 3系
     */
    public String getModelName() {
        return this.modelName;
    }

    /**
     * 设置 车系  模糊搜索例如 3系
     *
     * @param modelName 车系  模糊搜索例如 3系
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * 获取 品牌Id
     *
     * @return makeId 品牌Id
     */
    public Integer getMakeId() {
        return this.makeId;
    }

    /**
     * 设置 品牌Id
     *
     * @param makeId 品牌Id
     */
    public void setMakeId(Integer makeId) {
        this.makeId = makeId;
    }

    /**
     * 获取 车系Id
     *
     * @return modelId 车系Id
     */
    public Integer getModelId() {
        return this.modelId;
    }

    /**
     * 设置 车系Id
     *
     * @param modelId 车系Id
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    /**
     * 获取 车型Id
     *
     * @return styleId 车型Id
     */
    public Integer getStyleId() {
        return this.styleId;
    }

    /**
     * 设置 车型Id
     *
     * @param styleId 车型Id
     */
    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    /**
     * 获取 vin码
     *
     * @return vinCode vin码
     */
    public String getVinCode() {
        return this.vinCode;
    }

    /**
     * 设置 vin码
     *
     * @param vinCode vin码
     */
    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }



    /**
     * 获取 排序类型  1 在库天数最短 2 在库天数最长 3 标价最低 4 标价最高 5 车龄最短 6 里程最少
     *
     * @return sortType 排序类型  1 在库天数最短 2 在库天数最长 3 标价最低 4 标价最高 5 车龄最短 6 里程最少
     */
    public Integer getSortType() {
        return this.sortType;
    }

    /**
     * 设置 排序类型  1 在库天数最短 2 在库天数最长 3 标价最低 4 标价最高 5 车龄最短 6 里程最少
     *
     * @param sortType 排序类型  1 在库天数最短 2 在库天数最长 3 标价最低 4 标价最高 5 车龄最短 6 里程最少
     */
    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    /**
     * 获取 上牌时间
     *
     * @return regDate 上牌时间
     */
    public String getRegDate() {
        return this.regDate;
    }

    /**
     * 设置 上牌时间
     *
     * @param regDate 上牌时间
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }


    /**
     * 获取 变速箱
     *
     * @return variableBox 变速箱
     */
    public Integer getVariableBox() {
        return this.variableBox;
    }

    /**
     * 设置 变速箱
     *
     * @param variableBox 变速箱
     */
    public void setVariableBox(Integer variableBox) {
        this.variableBox = variableBox;
    }

    /**
     * 获取 车系级别
     *
     * @return modelLevel 车系级别
     */
    public Integer getModelLevel() {
        return this.modelLevel;
    }

    /**
     * 设置 车系级别
     *
     * @param modelLevel 车系级别
     */
    public void setModelLevel(Integer modelLevel) {
        this.modelLevel = modelLevel;
    }

    /**
     * 获取 排放标准
     *
     * @return emissionStandard 排放标准
     */
    public Integer getEmissionStandard() {
        return this.emissionStandard;
    }

    /**
     * 设置 排放标准
     *
     * @param emissionStandard 排放标准
     */
    public void setEmissionStandard(Integer emissionStandard) {
        this.emissionStandard = emissionStandard;
    }

    /**
     * 获取 颜色
     *
     * @return color 颜色
     */
    public Integer getColor() {
        return this.color;
    }

    /**
     * 设置 颜色
     *
     * @param color 颜色
     */
    public void setColor(Integer color) {
        this.color = color;
    }




    /**
     * 获取 当前页面
     *
     * @return pageNo 当前页面
     */
    public Integer getPageNo() {
        return this.pageNo;
    }

    /**
     * 设置 当前页面
     *
     * @param pageNo 当前页面
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取 每页的数量
     *
     * @return pageSize 每页的数量
     */
    public Integer getPageSize() {
        return this.pageSize;
    }

    /**
     * 设置 每页的数量
     *
     * @param pageSize 每页的数量
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * 获取 标价开始
     *
     * @return saleStartPrice 标价开始
     */
    public BigDecimal getSaleStartPrice() {
        return this.saleStartPrice;
    }

    /**
     * 设置 标价开始
     *
     * @param saleStartPrice 标价开始
     */
    public void setSaleStartPrice(BigDecimal saleStartPrice) {
        this.saleStartPrice = saleStartPrice;
    }

    /**
     * 获取 标价结束
     *
     * @return saleEndPrice 标价结束
     */
    public BigDecimal getSaleEndPrice() {
        return this.saleEndPrice;
    }

    /**
     * 设置 标价结束
     *
     * @param saleEndPrice 标价结束
     */
    public void setSaleEndPrice(BigDecimal saleEndPrice) {
        this.saleEndPrice = saleEndPrice;
    }

    /**
     * 获取 里程开始
     *
     * @return mileageStart 里程开始
     */
    public Integer getMileageStart() {
        return this.mileageStart;
    }

    /**
     * 设置 里程开始
     *
     * @param mileageStart 里程开始
     */
    public void setMileageStart(Integer mileageStart) {
        this.mileageStart = mileageStart;
    }

    /**
     * 获取 里程结束
     *
     * @return mileageEnd 里程结束
     */
    public Integer getMileageEnd() {
        return this.mileageEnd;
    }

    /**
     * 设置 里程结束
     *
     * @param mileageEnd 里程结束
     */
    public void setMileageEnd(Integer mileageEnd) {
        this.mileageEnd = mileageEnd;
    }

    /**
     * 获取 车龄开始
     *
     * @return carAgeStart 车龄开始
     */
    public Integer getCarAgeStart() {
        return this.carAgeStart;
    }

    /**
     * 设置 车龄开始
     *
     * @param carAgeStart 车龄开始
     */
    public void setCarAgeStart(Integer carAgeStart) {
        this.carAgeStart = carAgeStart;
    }

    /**
     * 获取 车龄结束
     *
     * @return carAgeEnd 车龄结束
     */
    public Integer getCarAgeEnd() {
        return this.carAgeEnd;
    }

    /**
     * 设置 车龄结束
     *
     * @param carAgeEnd 车龄结束
     */
    public void setCarAgeEnd(Integer carAgeEnd) {
        this.carAgeEnd = carAgeEnd;
    }

    /**
     * 获取 车辆状态
     *
     * @return vehicleStatus 车辆状态
     */
    public Integer getVehicleStatus() {
        return this.vehicleStatus;
    }

    /**
     * 设置 车辆状态
     *
     * @param vehicleStatus 车辆状态
     */
    public void setVehicleStatus(Integer vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    /**
     * 获取 客户ID
     *
     * @return customerId 客户ID
     */
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * 设置 客户ID
     *
     * @param customerId 客户ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取 搜索参数
     *
     * @return searchParam 搜索参数
     */
    public String getSearchParam() {
        return this.searchParam;
    }

    /**
     * 设置 搜索参数
     *
     * @param searchParam 搜索参数
     */
    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    /**
     * 获取 车型  模糊搜索例如
     *
     * @return styleName 车型  模糊搜索例如
     */
    public String getStyleName() {
        return this.styleName;
    }

    /**
     * 设置 车型  模糊搜索例如
     *
     * @param styleName 车型  模糊搜索例如
     */
    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }
}
