package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 16:11 on 2018/10/22.
 */
public enum MortgageStatusEnum {

    //抵押状态 0 未抵押 1 已抵押

    NOT_MORTGAGE(0,"未抵押"),
    MORTGAGE(1,"已抵押");

    private int value;
    private String text;

    MortgageStatusEnum(int value, String text){
        this.value = value;
        this.text = text;
    }

    public static MortgageStatusEnum getMortgageStatus(int value) {
        for (MortgageStatusEnum cs : MortgageStatusEnum.values()) {
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
