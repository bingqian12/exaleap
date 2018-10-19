package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:11 on 2018/9/28.
 */
public enum VehicleStatusEnum {

    //车辆状态  0:正常 1:锁定

    UNLOCK(0,"正常"),
    LOCK(1,"锁定"),
    SOLD(2,"已售");

    private int value;
    private String text;

    VehicleStatusEnum(int value, String text){
        this.value = value;
        this.text = text;
    }

    public static VehicleStatusEnum getVehicleStatus(int value) {
        for (VehicleStatusEnum cs : VehicleStatusEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
