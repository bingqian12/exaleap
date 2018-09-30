package com.jzg.svsp.common.enums;

/**
 * 排量枚举
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:08 on 2018/9/30.
 */
public enum DisplacementEnum {

    //1.0-1.6 1.6-2.0 2.0-3.0 3.0以上
    ONE_ONE_POINT_SIX(1, "1.0-1.6"),
    ONE_POINT_SIX_TWO(2, "1.6-2.0"),
    TWO_THREE(3, "2.0-3.0"),
    THREE_OVER(4, "3.0以上");

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
     DisplacementEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static DisplacementEnum getDisplacementEnum(int value) {
        for (DisplacementEnum cs : DisplacementEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return DisplacementEnum.THREE_OVER;
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
