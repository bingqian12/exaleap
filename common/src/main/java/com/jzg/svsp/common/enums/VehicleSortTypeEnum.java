package com.jzg.svsp.common.enums;

import com.jzg.svsp.common.constant.VehicleConstant;

/**
 * Created by JZG on 2017/6/8.
 */
public enum VehicleSortTypeEnum {

    //1 在库天数最短 2 在库天数最长 3 标价最低 4 标价最高 5 车龄最短 6 里程最少

    RELEASE_DESC(1, 0, VehicleConstant.releaseTime, "在库天数最短"),  //发布时间降序  在库天数最短

    RELEASE_ASC(2, 1, VehicleConstant.releaseTime, "在库天数最长"),  //发布时间升序  在库天数最长

    SELLPRICE_ASC(3, 1, VehicleConstant.toBPrice, "标价最低"),  //toBPrice升序  标价最低

    SELLPRICE_DESC(4, 0, VehicleConstant.toBPrice, "标价最高"),  //toBPrice降序 标价最高

    CAR_AGE_ASC(5, 1, VehicleConstant.carAge, "车龄最短"),  //车龄升序 车龄最短

    MILEAGE_ASC(6, 1, VehicleConstant.mileage, "里程最少");     //行驶里程升序 里程最少

    private int value;
    private int sortType;
    private String sortName;
    private String text;

    VehicleSortTypeEnum(int value, int sortType, String sortName, String text) {
        this.value = value;
        this.sortType = sortType;
        this.sortName = sortName;
        this.text = text;
    }

    public static VehicleSortTypeEnum getVehicleSortType(int value) {
        for (VehicleSortTypeEnum cs : VehicleSortTypeEnum.values()) {
            if (cs.getValue() == value) {
                return cs;
            }
        }
        return VehicleSortTypeEnum.RELEASE_DESC;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getSortName(){return sortName;}

    public int getSortType(){return sortType;}

}