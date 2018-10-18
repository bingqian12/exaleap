package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 16:25 on 2018/9/19.
 */
public enum EffluentStdEnum {

    //1国二及以下，2国三，3国四，4国五，5无法判断
    ONE(1, "国二及以下"),
    TWO(2, "国三"),
    THREE(3, "国四"),
    FOUR(4, "国五"),
    FIVE(5, "无法判断");

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
    private EffluentStdEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static EffluentStdEnum getEffluentStdEnum(int value) {
        for (EffluentStdEnum cs : EffluentStdEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return EffluentStdEnum.FIVE;
    }

    public static EffluentStdEnum getEffluentStdEnum(String value) {
        for (EffluentStdEnum cs : EffluentStdEnum.values()) {
            if (cs.getText().equals(value)) {
                return cs;
            }
        }
        return EffluentStdEnum.FIVE;
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
