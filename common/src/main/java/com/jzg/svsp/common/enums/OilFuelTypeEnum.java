package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 9:51 on 2018/10/10.
 */
public enum OilFuelTypeEnum {

    /**
     * 193	待查
     * 88	汽油
     * 203	柴油
     * 26	油气混合动力
     * 27	油电混合动力
     * 178	电力
     * 228	LPG
     * 243	CNG
     * 325	插电混合
     */


    GASOLINE(0, "汽油"),
    DIESEL_OIL(1, "柴油"),
    ELECTRIC(2, "电动"),
    OIL_ELECTRIC(3, "油电混动"),
    OTHER(4, "其他");

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

    public static OilFuelTypeEnum getOilFuelTypeById(int value) {

        switch (value) {
            case 88:
                return OilFuelTypeEnum.GASOLINE;
            case 203:
                return OilFuelTypeEnum.DIESEL_OIL;
            case 178:
                return OilFuelTypeEnum.ELECTRIC;
            case 27:
                return OilFuelTypeEnum.OIL_ELECTRIC;
            default:
                return OilFuelTypeEnum.GASOLINE;
        }

    }

    public static OilFuelTypeEnum getOilFuelType(int value) {
        for (OilFuelTypeEnum cs : OilFuelTypeEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return OilFuelTypeEnum.OTHER;
    }


    public static OilFuelTypeEnum getOilFuelType(String value) {
        for (OilFuelTypeEnum cs : OilFuelTypeEnum.values()) {
            if (cs.getText().equals(value)) {
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
