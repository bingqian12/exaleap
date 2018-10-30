package com.jzg.svsp.common.vo.product;

import lombok.Data;

import java.util.Date;

@Data
public class VehiclePicVo {
    private Long id;

    private Long vehicleId;

    private String picUrl;

    private Integer picType;

    private String picName;

    private String picDesc;

    private Date createTime;

    private Date updateTime;

}