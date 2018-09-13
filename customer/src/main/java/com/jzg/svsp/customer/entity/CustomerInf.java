package com.jzg.svsp.customer.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CustomerInf {
    private Long customerInfId;

    private Long customerId;

    private String customerName;

    private Byte identityCardType;

    private String identityCardNo;

    private Integer mobilePhone;

    private String customerEmail;

    private String gender;

    private Integer userPoint;

    private Date registerTime;

    private Date birthday;

    private Byte customerLevel;

    private BigDecimal userMoney;

    private Date modifiedTime;


}