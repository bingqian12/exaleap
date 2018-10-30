package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 19:25 on 2018/10/26.
 */
public enum VehiclePicTypeEnum {

    //车辆照片  0:车身外观 1:中控内饰 2:发动机底盘 3:手续照片

    STRUCTURE_APPEARANCE(0, "车身外观"),
    INTERIOR_DECORATION(1, "中控内饰"),
    ENGINE_CHASSIS(2, "发动机底盘"),
    PROCEDURE(3, "手续照片");

    private int value;
    private String text;

    VehiclePicTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static VehiclePicTypeEnum getVehiclePicType(int value) {
        for (VehiclePicTypeEnum cs : VehiclePicTypeEnum.values()) {
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
