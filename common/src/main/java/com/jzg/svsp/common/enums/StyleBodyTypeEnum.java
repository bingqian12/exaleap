package com.jzg.svsp.common.enums;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:22 on 2018/9/30.
 */
public enum StyleBodyTypeEnum {

/*
1	两厢车
2	三厢车
3	旅行车
4	轿跑车
5	掀背车
6	跨界车
7	SUV
8	跨界SUV
9	敞篷SUV
10	MPV
11	跨界MPV
12	硬顶跑车
13	敞篷跑车
14	常规皮卡
15	豪华皮卡
16	小型载客车
17	中型载客车
18	大型载客车
19	房车
20	开放式载货车
21	厢式载货车
22	挂车
23	工程车
24	其他
*/


    TWO_BOX(0, "两厢车"),
    THREE_BOX(1, "三厢车"),
    SPORT(2, "跑车"),
    SUV(3, "SUV"),
    MPV(4, "MPV"),
    TARVEL(5, "面包车"),
    PICKUP(6, "皮卡"),
    OTHER(7, "其他");

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
    StyleBodyTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static StyleBodyTypeEnum getStyleBodyType(int value) {
        for (StyleBodyTypeEnum cs : StyleBodyTypeEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return StyleBodyTypeEnum.OTHER;
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
