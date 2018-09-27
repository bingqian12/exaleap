package com.jzg.svsp.common.enums;

/**
 * Created by JZG on 2018/2/2.
 */
public enum ColorCorrespondEnum {

    black("黑色", "1", "1"),
    blue("蓝色", "2", "8"),
    brown("棕色", "3", "6"),
    golden("金色", "4", "10"),
    green("绿色", "5", "16"),
    grey("灰色", "6", "4"),
    orange("橙色", "7", "11"),
    pink("粉色", "8", "22"),
    purple("紫色", "9", "14"),
    red("红色", "10", "5"),
    silver("银色", "11", "3"),
    white("白色", "12", "2"),
    yellow("黄色", "13", "13"),
    cyan("青色", "14", "15"),
    twocolor("双色", "15", "21"),
    other("其他", "0", "23");

    private String baseColorId;
    private String baseColorName;
    private String oldColorId;

    ColorCorrespondEnum(String baseColorName, String baseColorId, String oldColorId) {
        this.baseColorId = baseColorId;
        this.baseColorName = baseColorName;
        this.oldColorId = oldColorId;
    }

    public static ColorCorrespondEnum getCarColorById(String colorId) {
        for (ColorCorrespondEnum carColor : ColorCorrespondEnum.values()) {
            if (carColor.baseColorId.equals(colorId)) {
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


    public String getBaseColorId() {
        return baseColorId;
    }

    public String getBaseColorName() {
        return baseColorName;
    }

    public String getOldColorId() {
        return oldColorId;
    }
}
