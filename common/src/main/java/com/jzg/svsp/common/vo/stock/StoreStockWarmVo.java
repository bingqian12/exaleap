package com.jzg.svsp.common.vo.stock;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 13:55 on 2018/10/16.
 */
@Data
public class StoreStockWarmVo implements BaseVo{

    /**
     * 店铺ID
     */
    private Integer storeId;
    /**
     * 店铺名称
     */
    private String storeName;
    /**
     * 库存总量
     */
    private Integer total;
    /**
     * 已上架
     */
    private Integer upShelf;
    /**
     * 未上架
     */
    private Integer downShelf;
    /**
     * 已预售
     */
    private Integer preSale;

    /**
     * 库存超期
     */
    private Integer stockAgeCount;
    /**
     * 上架超期
     */
    private Integer overdueDateCount;
    /**
     * 浏览量过低
     */
    private Integer viewLowCount;
    /**
     * 今日新增本地车源
     */
    private Integer localTodayAdd;

    /**
     * 今日新增全国车源
     */
    private Integer allTodayAdd;
}
