package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:11 on 2018/9/28.
 */
public enum ShelfStatusEnum {

    //上架状态 0:下架  1:上架

    DOWN_SHELF(0,"下架"),
    UP_SHELF(1,"上架"),
    FORCE_UP_SHELF(2,"强制下架");

    private int value;
    private String text;

    ShelfStatusEnum(int value, String text){
        this.value = value;
        this.text = text;
    }

    public static ShelfStatusEnum getShelfStatus(int value) {
        for (ShelfStatusEnum cs : ShelfStatusEnum.values()) {
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
