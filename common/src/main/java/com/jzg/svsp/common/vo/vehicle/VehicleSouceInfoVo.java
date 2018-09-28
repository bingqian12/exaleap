package com.jzg.svsp.common.vo.vehicle;


import com.jzg.svsp.common.vo.BaseVo;

/**
 * Created by JZG on 2018/8/15.
 */
public class VehicleSouceInfoVo implements BaseVo {

    private Long id;
    private Long custId;
    private String img;
    private String styleFullName;//车型全称
    private String mileage;//公里数
    private String regDate;//上牌时间
    private String cityName;//城市
    private String releaseTime;//发布时间
    private Integer vehicleStatus;//状态

    public VehicleSouceInfoVo() {
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

    /**
     * 获取
     *
     * @return releaseTime
     */
    public String getReleaseTime() {
        return this.releaseTime;
    }

    /**
     * 设置
     *
     * @param releaseTime
     */
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 获取
     *
     * @return custId
     */
    public Long getCustId() {
        return this.custId;
    }

    /**
     * 设置
     *
     * @param custId
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }
}
