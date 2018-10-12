package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:24 on 2018/9/30.
 */
public enum PlaceOfOriginEnum {

    //国别(1:中国 2:美国 3:日本 4:韩国 5:德国 6:英国 7:法国 999:其他)

    CHINA(1, "中国"),
    AMERICA(2, "美国"),
    JAPAN(3, "日本"),
    KOREA(4, "韩国"),
    GERMANY(5, "德国"),
    BRITAIN(6, "英国"),
    FRANCE(7, "法国"),
    OTHER(8, "其他");

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

    public static PlaceOfOriginEnum getPlaceOfOriginEnum(int value) {
        for (PlaceOfOriginEnum cs : PlaceOfOriginEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return PlaceOfOriginEnum.OTHER;
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
