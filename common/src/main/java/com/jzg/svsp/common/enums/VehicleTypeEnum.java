package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 16:48 on 2018/9/28.
 */
public enum VehicleTypeEnum {

    TO_B(0,"toB"),
    TO_C(1,"toC"),
    TO_B_AND_TO_C(2,"toB and toC");

    private int value;
    private String text;

    VehicleTypeEnum(int value, String text){
        this.value = value;
        this.text = text;
    }

    public static VehicleTypeEnum getVehicleType(int value) {
        for (VehicleTypeEnum cs : VehicleTypeEnum.values()) {
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
