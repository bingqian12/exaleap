package com.jzg.svsp.common.enums;

/**
 * @author: YuGenHai
 * @name: OrderCarStatusEnum
 * @creation: 2018/10/18 11:42
 * @notes:  订单锁车
 */
public enum OrderCarStatusEnum {


    /**
     * 更新车辆状态
     * 1. vehicleId 车源ID   [必填]
     * 2. vehicleStatus 车辆状态  0:已锁定 1:车辆解锁 2:待过户 3:已过户 [必填]
     */

    CAR_LOCK(0,"已锁定"),
    CAR_UNLOCK(1,"车辆解锁"),
    CAR_TRANSFER_N(2,"待过户"),
    CAR_TRANSFER_Y(3,"已过户");

    /**
     * key
     */
    private int key;

    /**
     * value
     */
    private String value;


    OrderCarStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
