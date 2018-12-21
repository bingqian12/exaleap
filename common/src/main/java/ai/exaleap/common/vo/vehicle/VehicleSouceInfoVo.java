package ai.exaleap.common.vo.vehicle;


import ai.exaleap.common.vo.BaseVo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by JZG on 2018/8/15.
 */
@Data
public class VehicleSouceInfoVo implements BaseVo {

    private Long id;
    private Long storeId;//店铺ID
    private String img;//车辆主图
    private String styleFullName;//车型全称
    private String mileage;//公里数
    private String regDate;//上牌时间
    private Integer cityId;//上牌城市
    private String cityName;//上牌城市
    private Integer locationCityId;//所在地城市
    private String locationCityName;//所在地城市
    private String releaseTime;//发布时间
    private String createTime;//入库时间
    private Integer shelfStatus;//上架状态
    private String shelfStatusDesc; //上架状态
    private Integer vehicleStatus;//车辆状态
    private String vehicleStatusDesc;//车辆状态
    private Integer mortgageStatus;//抵押状态
    private String mortgageStatusDesc;//抵押状态
    private String vinCode;//VIN
    private BigDecimal toBPrice;//直销价
    private BigDecimal toCPrice;//分销价
    private Integer viewNum;//浏览数
    private String storeName;//店铺名称
    private Integer saleStatus;//可售状态 0 不可售 1 可售
    private Integer libraryStatus;//在库状态 0 不在库 1 在库
    private Integer marketId;//市场ID
    private String marketName;//市场名称
    private String marketAddress;//市场地址
    private String contactNumber;//联系电话
    private String chatUser;//聊天
    private Integer checkStatus; //严选车 1
}
