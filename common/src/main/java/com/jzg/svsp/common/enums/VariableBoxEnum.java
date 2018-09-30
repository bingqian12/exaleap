package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:22 on 2018/9/30.
 */
public enum VariableBoxEnum {

    //1国二及以下，2国三，3国四，4国五，5无法判断
    AUTOMATIC(1, "自动"),
    MANUAL(2, "手动");

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
    VariableBoxEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static VariableBoxEnum getVariableBoxEnum(int value) {
        for (VariableBoxEnum cs : VariableBoxEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return VariableBoxEnum.AUTOMATIC;
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
