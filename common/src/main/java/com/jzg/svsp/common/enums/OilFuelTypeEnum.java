package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 9:51 on 2018/10/10.
 */
public enum OilFuelTypeEnum {

    /**
     193	待查
     88	    汽油
     203	柴油
     26	    油气混合动力
     27	    油电混合动力
     178	电力
     228	LPG
     243	CNG
     325	插电混合
     */


    GASOLINE(1, "汽油"),
    DIESEL_OIL(2, "柴油"),
    ELECTRIC(3, "电动"),
    OIL_ELECTRIC(4, "油电混动"),
    OTHER(5, "其他");

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
    OilFuelTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static OilFuelTypeEnum getOilFuelTypeEnum(int value) {
        for (OilFuelTypeEnum cs : OilFuelTypeEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return OilFuelTypeEnum.OTHER;
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
