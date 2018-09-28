package com.jzg.svsp.common.vo.vehicle;

import com.jzg.svsp.common.vo.BaseVo;

import java.math.BigDecimal;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:10 on 2018/9/25.
 */
public class VehicleInfoVo implements BaseVo {

    private String id;
    /**
     * 客户ID
     */
    private Long custId;
    /**
     * 品牌  模糊搜索例如 宝马
     */
    private String makeName;
    /**
     * 车系  模糊搜索例如 3系
     */
    private String modelName;
    /**
     * 车型名称
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
     * 车辆状态 0:下架  1:上架  2:未锁定 3:已锁定 4:车辆解锁 5:待过户 6:已过户
     */
    private Integer vehicleStatus;
    /**
     * 上牌时间
     */
    private String regDate;
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
     * 里程
     */
    private Integer mileage;
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
     * 上牌城市
     */
    private Integer cityId;
    /**
     * 上牌城市
     */
    private String cityName;

    private String orderId;

    private String img;

    private String styleFullName;//车型全称

    private String checkDate;//检测时间

    private Integer carAge;
    /**
     * 发布时间
     */
    private String releaseTime;
    /**
     * 检测报告
     */
    private String report;

    /**
     * 获取 @Id
     *
     * @return id @Id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置 @Id
     *
     * @param id @Id
     */
    public void setId(String id) {
        this.id = id;
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
     * 获取 里程
     *
     * @return mileage 里程
     */
    public Integer getMileage() {
        return this.mileage;
    }

    /**
     * 设置 里程
     *
     * @param mileage 里程
     */
    public void setMileage(Integer mileage) {
        this.mileage = mileage;
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
     * 获取 车型名称
     *
     * @return styleName 车型名称
     */
    public String getStyleName() {
        return this.styleName;
    }

    /**
     * 设置 车型名称
     *
     * @param styleName 车型名称
     */
    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    /**
     * 获取 上牌城市
     *
     * @return cityName 上牌城市
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     * 设置 上牌城市
     *
     * @param cityName 上牌城市
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取 上牌城市
     *
     * @return cityId 上牌城市
     */
    public Integer getCityId() {
        return this.cityId;
    }

    /**
     * 设置 上牌城市
     *
     * @param cityId 上牌城市
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }


    /**
     * 获取
     *
     * @return orderId
     */
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * 设置
     *
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取
     *
     * @return img
     */
    public String getImg() {
        return this.img;
    }

    /**
     * 设置
     *
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取
     *
     * @return styleFullName
     */
    public String getStyleFullName() {
        return this.styleFullName;
    }

    /**
     * 设置
     *
     * @param styleFullName
     */
    public void setStyleFullName(String styleFullName) {
        this.styleFullName = styleFullName;
    }

    /**
     * 获取
     *
     * @return checkDate
     */
    public String getCheckDate() {
        return this.checkDate;
    }

    /**
     * 设置
     *
     * @param checkDate
     */
    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 获取
     *
     * @return carAge
     */
    public Integer getCarAge() {
        return this.carAge;
    }

    /**
     * 设置
     *
     * @param carAge
     */
    public void setCarAge(Integer carAge) {
        this.carAge = carAge;
    }


    /**
     * 获取 发布时间
     *
     * @return releaseTime 发布时间
     */
    public String getReleaseTime() {
        return this.releaseTime;
    }

    /**
     * 设置 发布时间
     *
     * @param releaseTime 发布时间
     */
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 获取 车辆状态 0:下架  1:上架  2:未锁定 3:已锁定 4:车辆解锁 5:待过户 6:已过户
     *
     * @return vehicleStatus 车辆状态 0:下架  1:上架  2:未锁定 3:已锁定 4:车辆解锁 5:待过户 6:已过户
     */
    public Integer getVehicleStatus() {
        return this.vehicleStatus;
    }

    /**
     * 设置 车辆状态 0:下架  1:上架  2:未锁定 3:已锁定 4:车辆解锁 5:待过户 6:已过户
     *
     * @param vehicleStatus 车辆状态 0:下架  1:上架  2:未锁定 3:已锁定 4:车辆解锁 5:待过户 6:已过户
     */
    public void setVehicleStatus(Integer vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }


    /**
     * 获取 检测报告
     *
     * @return report 检测报告
     */
    public String getReport() {
        return this.report;
    }

    /**
     * 设置 检测报告
     *
     * @param report 检测报告
     */
    public void setReport(String report) {
        this.report = report;
    }
}
