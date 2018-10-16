package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:11 on 2018/9/28.
 */
public enum VehicleStatusEnum {

    //车辆状态  0:未锁定 1:已锁定 2:待过户 3:已过户

    UNLOCK(0,"未锁定"),
    LOCK(1,"已锁定"),
    WAIT_TRANSFER(2,"待过户"),
    COMPLETE_TRANSFER(3,"已过户");

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
