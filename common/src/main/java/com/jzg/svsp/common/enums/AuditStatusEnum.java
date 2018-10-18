package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:11 on 2018/9/28.
 */
public enum AuditStatusEnum {

    //上架状态 0:下架  1:上架

    INIT_STATUS(0,"初始值"),
    AUDITING(1,"待审核"),
    AUDIT_PASS(2,"审核通过"),
    AUDIT_REJECT(3,"审核不通过");

    private int value;
    private String text;

    AuditStatusEnum(int value, String text){
        this.value = value;
        this.text = text;
    }

    public static AuditStatusEnum getAuditStatus(int value) {
        for (AuditStatusEnum cs : AuditStatusEnum.values()) {
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
