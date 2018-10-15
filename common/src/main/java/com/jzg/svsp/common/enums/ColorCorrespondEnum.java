package com.jzg.svsp.common.enums;

/**
 * Created by JZG on 2018/2/2.
 */
public enum ColorCorrespondEnum {

    black("黑色", 1),
    blue("白色", 2),
    brown("银灰色", 3),
    golden("深灰色", 4),
    green("红色", 5),
    grey("橙色", 6),
    orange("绿色", 7),
    pink("蓝色", 8),
    purple("咖啡色", 9),
    red("紫色", 10),
    silver("香槟色", 11),
    white("多彩色", 12),
    yellow("黄色", 13),
    other("其他", 14);

    private int baseColorId;
    private String baseColorName;

    ColorCorrespondEnum(String baseColorName, int baseColorId) {
        this.baseColorId = baseColorId;
        this.baseColorName = baseColorName;
    }

    public static ColorCorrespondEnum getCarColorById(int colorId) {
        for (ColorCorrespondEnum carColor : ColorCorrespondEnum.values()) {
            if (carColor.baseColorId == colorId) {
                return carColor;
            }
        }
        return ColorCorrespondEnum.other;
    }

    public static ColorCorrespondEnum getCarColorByColor(String color) {
        for (ColorCorrespondEnum carColor : ColorCorrespondEnum.values()) {
            if (carColor.baseColorName.equals(color)) {
                return carColor;
            }
        }
        return ColorCorrespondEnum.other;
    }


    public int getBaseColorId() {
        return baseColorId;
    }

    public String getBaseColorName() {
        return baseColorName;
    }


}
