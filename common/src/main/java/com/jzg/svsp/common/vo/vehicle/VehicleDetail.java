package com.jzg.svsp.common.vo.vehicle;

import com.alibaba.fastjson.JSONArray;
import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 15:57 on 2018/10/25.
 */
@Data
public class VehicleDetail implements BaseVo {
    private Integer viewNum; //浏览数
    private BigDecimal toBPrice;  //直销价
    private BigDecimal toCPrice;  //分销价
    private Integer checkStatus; //0 初检 1 复检
    private String vehicleBusinessId;  //车辆业务ID
    private String vehicleId;  //车辆ID
    private String accident; //事故等级 A B C D
    private String vinCode; //vin码
    private Integer stockAge;  //库龄
    private Integer styleId;   //车型ID
    private String styleFullName; //车型全称
    private Integer cityId;    //上牌城市
    private String cityName;   //上牌城市
    private String regDate;    //上牌时间
    private String mileage;    //行驶里程
    private String releaseTime; //发布时间
    private BigDecimal referencePriceMin; //参考价
    private BigDecimal referencePriceMax; //参考价
    private String emissionStandard; //排放标准
    private String carLicense; //牌照
    private String styleBodyType; //车体类型
    private BigDecimal newCarPrice; //新车价
    private BigDecimal purchaseTax; //购置税
    private Long storeId; //店铺Id
    private String storeName; //店铺名称
    private String storeAddress; //店铺地址
    private String dealerPhone; //车商电话
    private String marketName; //市场地址
    private String marketAddress; //市场名称
    private String exhaust; //排量
    private String variableBox; //变速箱
    private String insurance; //交强险
    private String inspection; //年检
    private String drivingLicense; //行驶证
    private String registration; //登记证
    private String key; //钥匙
    private String color; //颜色
    private String locationProvinceId; //车源所在省
    private String locationProvinceName; //车源所在省
    private String locationCityId; //车源所在市
    private String locationCityName; //车源所在市
    private Integer transferCount; //过户次数
    private String productionTime; //生产日期
    private String checkDescription; //检测描述
    private String appearanceDiagrammaticLink; //外观示意图
    private String structureDiagrammaticLink; //结构示意图
    private String decorateDiagrammaticLink; //内饰示意图
    private BaseVehicleDetail engineCheck; //机舱检查
    private BaseVehicleDetail chassisCheck; //底盘检查
    private BaseVehicleDetail electricalCheck; //电气检查
    private BaseVehicleDetail appearanceDecorateCheck; //外观内饰检查
    private BaseVehicleDetail slightAccidentCheck; //轻微事故检查
    private BaseVehicleDetail majorAccidentCheck; //重大事故检查
    private BaseVehicleDetail roadTestCheck; //路试检查
    private JSONArray basicPic; //基本照片
    private JSONArray vehicleRealBeat; //车辆实拍
    private JSONArray procedurePic; //手续照片
    private List<VehicleRecommendVo> sameModelList; //同车系
    private List<VehicleRecommendVo> samePriceList; //同价位
    private List<BrightConfig> brightConfigs; //亮点配置


}
