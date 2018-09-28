package com.jzg.svsp.common.vo.vehicle;


import com.jzg.svsp.common.vo.BaseVo;

/**
 * Created by JZG on 2018/8/15.
 */
public class VehicleSouceInfoVo implements BaseVo {

    private Long id;
    private String orderId;
    private String img;
    private String styleFullName;//车型全称
    private String mileage;//公里数
    private String regDate;//上牌时间
    private String cityName;//城市
    private String checkDate;//检测时间
    private Integer vehicleStatus;//状态

    public VehicleSouceInfoVo(){}

    public VehicleSouceInfoVo(Long id,String orderId,String img,String styleFullName,String mileage,String regDate,String cityName,String checkDate,Integer vehicleStatus){
        this.id = id;
        this.orderId = orderId;
        this.styleFullName = styleFullName;
        this.mileage = mileage;
        this.regDate = regDate;
        this.cityName = cityName;
        this.checkDate = checkDate;
        this.vehicleStatus = vehicleStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getStyleFullName() {
        return styleFullName;
    }

    public void setStyleFullName(String styleFullName) {
        this.styleFullName = styleFullName;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }



    /**
     * 获取
     *
     * @return img
     */
    public String getImg() {
        return this.img;
    }

    /**
     * 设置
     *
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取
     *
     * @return regDate
     */
    public String getRegDate() {
        return this.regDate;
    }

    /**
     * 设置
     *
     * @param regDate
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }


    /**
     * 获取
     *
     * @return vehicleStatus
     */
    public Integer getVehicleStatus() {
        return this.vehicleStatus;
    }

    /**
     * 设置
     *
     * @param vehicleStatus
     */
    public void setVehicleStatus(Integer vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
