package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:24 on 2018/9/30.
 */
public enum PlaceOfOriginEnum {

    //产地
    DOMESTIC(0, "国产"),
    IMPORTED(1, "进口");

    /**
     * value
     */
    private int value;

    /**
     * text
     */
    private String text;

    /**
     * 构造方法
     *
     * @param value 状态码
     * @param text  文字说明
     */
    PlaceOfOriginEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static PlaceOfOriginEnum getPlaceOfOrigin(int value) {
        for (PlaceOfOriginEnum cs : PlaceOfOriginEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return PlaceOfOriginEnum.DOMESTIC;
    }

    public static PlaceOfOriginEnum getPlaceOfOrigin(String text) {
        for (PlaceOfOriginEnum cs : PlaceOfOriginEnum.values()) {
            if (cs.getText().equals(text)) {
                return cs;
            }
        }
        return PlaceOfOriginEnum.DOMESTIC;
    }

    /**
     * 获取value
     *
     * @return 状态码
     */
    public int getValue() {
        return this.value;
    }

    /**
     * 获取说明
     *
     * @return 文字说明
     */
    public String getText() {
        return this.text;
    }
}
