package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:27 on 2018/10/9.
 */
public enum ModelLevelEnum {

/*
1	微型车
2	小型车
3	紧凑型车
4	中型车
5	中大型车
6	大型车
7	小型SUV
8	紧凑型SUV
9	中型SUV
10	中大型SUV
11	大型SUV
12	小型MPV
13	大型MPV
14	入门级跑车
15	中级跑车
16	超级跑车
17	皮卡
18	载客
19	载货
20	其他
*/

    //SUV、MPV、敞篷车、跑车、两厢车、三厢车、旅行车、皮卡、单厢、两厢半、7座SUV、其他

    SUV(1, "SUV"),
    MPV(2, "MPV"),
    OPEN(3, "敞篷车"),
    SPORT(4, "跑车"),
    TWO_BOX(5, "两厢车"),
    THREE_BOX(6, "三厢车"),
    TARVEL(7, "旅行车"),
    PICKUP(8, "皮卡"),
    ONE_BOX(9, "单厢"),
    TWO_BOX_HALF(10, "两厢半"),
    SEVEN_SEATS_SUV(11, "7座SUV"),
    OTHER(12, "其他");

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
    ModelLevelEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static ModelLevelEnum getModelLevel(int value) {
        for (ModelLevelEnum cs : ModelLevelEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return ModelLevelEnum.OTHER;
    }
    public static ModelLevelEnum getModelLevel(String value) {
        for (ModelLevelEnum cs : ModelLevelEnum.values()) {
            if (cs.getText().equals(value)) {
                return cs;
            }
        }
        return ModelLevelEnum.OTHER;
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
