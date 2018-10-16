package com.jzg.svsp.common.vo.vehicle;


import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by JZG on 2018/8/15.
 */
@Data
public class VehicleSouceInfoVo implements BaseVo {

    private Long id;
    private Long storeId;
    private String img;
    private String styleFullName;//车型全称
    private String mileage;//公里数
    private String regDate;//上牌时间
    private String cityName;//城市
    private String releaseTime;//发布时间
    private Integer shelfStatus;//上架状态
    private String shelfStatusDesc; //上架状态
    private Integer vehicleStatus;//车辆状态
    private String vehicleStatusDesc;//车辆状态
    private Integer mortgageStatus;//抵押状态
    private String mortgageStatusDesc;//抵押状态
    private String vinCode;//VIN
    /**
     * 卖给车商价格
     */
    private BigDecimal toBPrice;
    /**
     * 卖给个人价格
     */
    private BigDecimal toCPrice;
    /**
     * 浏览数
     */
    private Integer viewNum;
    /**
     * 店铺名称
     */
    private String shopName;


}
