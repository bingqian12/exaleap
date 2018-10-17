package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:11 on 2018/9/28.
 */
public enum LibraryStatusEnum {

    //在库状态 0 不在库 1 在库

    DOWN_SHELF(0,"不在库"),
    UP_SHELF(1,"在库");

    private int value;
    private String text;

    LibraryStatusEnum(int value, String text){
        this.value = value;
        this.text = text;
    }

    public static LibraryStatusEnum getLibraryStatus(int value) {
        for (LibraryStatusEnum cs : LibraryStatusEnum.values()) {
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
