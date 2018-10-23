package com.jzg.svsp.common.enums;

/**
 * @author: YuGenHai
 * @name: OrderCarStatusEnum
 * @creation: 2018/10/23 10:48
 * @notes:  锁定校验
 */
public enum OrderCarStatusEnum {

    CAR_LOCK(0, "锁定"),
    CAR_NORMAL(1, "正常"),
    CAR_SOLD(2, "已售");

    private int key;
    private String value;

    private OrderCarStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
