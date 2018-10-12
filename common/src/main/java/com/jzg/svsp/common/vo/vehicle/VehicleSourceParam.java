package com.jzg.svsp.common.vo.vehicle;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 15:10 on 2018/9/25.
 */
@Data
public class VehicleSourceParam implements BaseVo{

    /**
     * 客户ID
     */
    private Long customerId;
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
     * 车辆类别 0 toB 1 toC 2 toB and toC
     */
    private Integer vehicleType;
    /**
     * 包含过户费 0 不包含 1 包含
     */
    private Integer transferFeeFlag;
    /**
     * 包含运费 0 不包含 1 包含
     */
    private Integer freightFeeFlag;
    /**
     * 车源状态 0 下架 1 上架
     */
    private Integer shelfStatus;
    /**
     * 车辆状态  0:未锁定 1:已锁定 2:待过户 3:已过户
     */
    private Integer vehicleStatus;
    /**
     * 当前页码
     */
    private Integer pageNo;
    /**
     * 每页条数
     */
    private Integer pageSize;





}
