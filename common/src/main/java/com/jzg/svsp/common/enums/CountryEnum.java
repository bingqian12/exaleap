package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 9:51 on 2018/10/10.
 */
public enum CountryEnum {

    //0 德系、1 日系、2 美系、3 法系、4 韩系、5 国产、6其他

    GERMANY(0, "德国"),
    JAPAN(1, "日本"),
    AMERICA(2, "美国"),
    FRANCE(3, "法国"),
    KOREA(4, "韩国"),
    CHINA(5, "中国"),
    OTHER(6, "其他");

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
    CountryEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static CountryEnum getCountryEnum(int value) {
        for (CountryEnum cs : CountryEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return CountryEnum.OTHER;
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
