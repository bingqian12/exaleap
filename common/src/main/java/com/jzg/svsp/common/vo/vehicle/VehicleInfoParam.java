package com.jzg.svsp.common.vo.vehicle;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:10 on 2018/9/25.
 */
@Data
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
     * 上架状态 0 下架 1 上架
     */
    private String shelfStatus;
    /**
     * 车辆状态 0 未锁定 1 已锁定 2 待过户 3 已过户
     */
    private String vehicleStatus;
    /**
     * 抵押状态 0 未抵押 1 已抵押
     */
    private String mortgageStatus;

    /**
     * 排序类型  1 在库天数最短 2 在库天数最长 3 标价最低 4 标价最高 5 车龄最短 6 里程最少
     */
    private Integer sortType;
    /**
     * 上牌时间
     */
    private String regDate;
    /**
     * 上牌时间
     */
    private String regDateStart;
    /**
     * 上牌时间
     */
    private String regDateEnd;
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
    private String variableBox;
    /**
     * 车系级别
     */
    private String modelLevel;
    /**
     * 排放标准
     */
    private String emissionStandard;
    /**
     * 颜色
     */
    private Integer color;
    /**
     * 省份Id
     */
    private String provinceId;
    /**
     * 城市Id
     */
    private String cityId;
    /**
     * 当前页面
     */
    private Integer pageNo = 1;
    /**
     * 每页的数量
     */
    private Integer pageSize = 10;
    /**
     * 门店ID
     */
    private String storeId;
    /**
     * 座位数
     */
    private String seatCount;

    private String placeOfOrigin;

}
