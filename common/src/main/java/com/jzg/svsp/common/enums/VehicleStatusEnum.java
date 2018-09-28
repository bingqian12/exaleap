package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:11 on 2018/9/28.
 */
public enum VehicleStatusEnum {

    //车辆状态 0:下架  1:上架  2:已锁定 3:车辆解锁 4:待过户 5:已过户

    DOWN_SHELF(0,"下架"),
    UP_SHELF(1,"上架"),
    LOCK(2,"已锁定"),
    UNLOCK(3,"车辆解锁"),
    WAIT_TRANSFER(4,"待过户"),
    COMPLETE_TRANSFER(5,"已过户");

    private int value;
    private String text;

    VehicleStatusEnum(int value, String text){
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
