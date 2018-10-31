package com.jzg.svsp.common.vo.product;

import lombok.Data;

import java.util.Date;

@Data
public class VehicleLicenseCertificateVo {

    private Long id;

    /**
     * 车辆ID
     */
    private Long vehicleId;

    /**
     * 行驶证 0 无 1 有
     */
    private Integer drivingLicense;

    /**
     * 登记证 0 无 1 有
     */
    private Integer registration;

    /**
     * 购置税证 0 无 1 有
     */
    private Integer purchaseTaxCard;

    /**
     * 过户次数
     */
    private Integer transferNum;

    /**
     * 原车主身份证 0 否 1 是
     */
    private Integer originalOwnerIdCard;

    /**
     * 钥匙
     */
    private Integer vehicleKey;

    /**
     * 交强险 0 无 1 有
     */
    private Integer strongInsurance;

    /**
     * 年检到期日
     */
    private String annualInspectionDueDay;

    /**
     * 原车主商业险  0 无 1 有
     */
    private Integer originalBusinessInsurance;

    /**
     * 原车牌照  0 无 1 有
     */
    private Integer originalVehicleLicense;

    /**
     * 铭牌  0 无 1 有
     */
    private Integer nameplate;

    /**
     * 车辆说明书 0 无 1 有
     */
    private Integer vehicleManua;

    /**
     * 发动机号
     */
    private String engineNum;

    /**
     * 登记证号
     */
    private String registrationCarNum;

    /**
     * 原车档案  0 无 1 有
     */
    private Integer originalVehicleArchives;

    /**
     * 交易发票  0 无 1 有
     */
    private Integer transactionInvoice;

    /**
     * 4S定期保养  0 无 1 有
     */
    private Integer fourSRegularMaintenance;



}