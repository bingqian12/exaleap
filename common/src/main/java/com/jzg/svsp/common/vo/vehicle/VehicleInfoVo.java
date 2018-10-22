package com.jzg.svsp.common.vo.vehicle;

import com.alibaba.fastjson.JSONObject;
import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:10 on 2018/9/25.
 */
@Data
public class VehicleInfoVo implements BaseVo {

    private String id;
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
    private String mileage;
    /**
     * 变速箱
     */
    private Integer variableBox;
    /**
     * 变速箱
     */
    private String variableBoxName;
    /**
     * 车系级别
     */
    private Integer modelLevel;
    /**
     * 车系级别
     */
    private String modelLevelName;
    /**
     * 排放标准
     */
    private Integer emissionStandard;
    /**
     * 排放标准
     */
    private String emissionStandardName;
    /**
     * 颜色
     */
    private Integer colorId;
    /**
     * 颜色
     */
    private String color;
    /**
     * 上牌城市
     */
    private Integer cityId;
    /**
     * 上牌城市
     */
    private String cityName;
    /**
     * 主图
     */
    private String img;
    /**
     * 车型全称
     */
    private String styleFullName;
    /**
     * 车龄
     */
    private Integer carAge;
    /**
     * 发布时间
     */
    private String releaseTime;
    /**
     * 检测报告
     */
    private JSONObject report;
    /**
     * 牌照
     */
    private String carLicense;
    /**
     * 库存天数
     */
    private Integer stockAge;
    /**
     * 车体类型
     */
    private Integer styleBodyType;
    /**
     * 车体类型
     */
    private String styleBodyTypeName;
    /**
     * 新车价
     */
    private BigDecimal newCarPrice;
    /**
     * 购置税
     */
    private BigDecimal purchaseTax;
    /**
     * 店铺Id
     */
    private Long storeId;
    /**
     * 店铺名称
     */
    private String storeName;
    /**
     * 店铺地址
     */
    private String storeAddress;

}
