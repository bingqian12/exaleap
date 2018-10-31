package com.jzg.svsp.common.vo.vehicle;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 17:08 on 2018/10/23.
 */
@Data
public class VehicleRecommendVo {

    private Long vehicleId;

    private Integer makeId;

    private Integer modelId;

    private Integer styleId;

    private String styleFullName;

    private String regDate;

    private String mileage;

    private Integer cityId;

    private String cityName;

    private BigDecimal toBPrice;

    private BigDecimal toCPrice;

    private String releaseTime;

    private String img;

}
