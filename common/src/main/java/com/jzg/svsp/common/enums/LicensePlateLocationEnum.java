package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 16:38 on 2018/10/17.
 */
public enum LicensePlateLocationEnum {

    //0 本地、1 外地

    LOCAL(0, "本地"),
    NOLOCAL(1, "外地");

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
    LicensePlateLocationEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static LicensePlateLocationEnum getLicensePlateLocation(int value) {
        for (LicensePlateLocationEnum cs : LicensePlateLocationEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return LicensePlateLocationEnum.NOLOCAL;
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
