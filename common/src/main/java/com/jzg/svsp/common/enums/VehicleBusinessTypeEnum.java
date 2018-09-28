package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 16:48 on 2018/9/28.
 */
public enum VehicleBusinessTypeEnum {

    B_TO_B(0,"toB"),
    B_TO_C(1,"toC");

    private int value;
    private String text;

    VehicleBusinessTypeEnum(int value, String text){
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
