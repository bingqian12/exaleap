package com.jzg.svsp.common.vo.vehicle;

import lombok.Data;

import java.util.List;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 19:04 on 2018/10/16.
 */
@Data
public class VehicleSearchParamVo {
    private Integer storeId;
    private String vinCode;
    private List<String> storeIds;
    private Integer shelfStatus;
    private Integer vehicleStatus;
    private Integer saleStatus;
    private Integer libraryStatus;
    private String createTime;
    private String shelfTime;
    private Integer viewNum;
    private Integer locationProvinceId;
    private Integer auditStatus;
    private String submitAuditTimeStart;
    private String submitAuditTimeEnd;
    private Integer pageNo;
    private Integer pageSize;
    private String carLicense;
    private String styleFullName;
    private Integer mileageStart;
    private Integer mileageEnd;
    private String shopName;
}
