package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:22 on 2018/9/30.
 */
public enum VariableBoxEnum {

/*
69	手动
208	半自动
3	自动
64	手自一体
242	CVT无级变速
60	双离合
180	电动车单速变速箱
193	待查
237	E-CVT无级变速
*/

    MANUAL(0, "手动"),
    AUTOMATIC(1, "自动");

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

    public static VariableBoxEnum getVariableBoxById(int value) {

        switch (value) {
            case 69:
                return VariableBoxEnum.MANUAL;
            default:
                return VariableBoxEnum.AUTOMATIC;
        }

    }

    public static VariableBoxEnum getVariableBox(int value) {
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
