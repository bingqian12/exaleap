package com.jzg.svsp.customer.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CustomerBalanceLog {
    private Long balanceId;

    private Long customerId;

    private Byte source;

    private Integer sourceSn;

    private Date createTime;

    private BigDecimal amount;


}