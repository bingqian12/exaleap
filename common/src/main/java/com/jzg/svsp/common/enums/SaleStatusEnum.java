package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:11 on 2018/9/28.
 */
public enum SaleStatusEnum {

    //可售状态 0 不可售 1 可售

    NOT_SALE(0,"不可售"),
    SALE(1,"可售");

    private int value;
    private String text;

    SaleStatusEnum(int value, String text){
        this.value = value;
        this.text = text;
    }

    public static SaleStatusEnum getSaleStatus(int value) {
        for (SaleStatusEnum cs : SaleStatusEnum.values()) {
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
