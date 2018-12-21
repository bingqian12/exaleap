package ai.exaleap.common.vo.stock;

import ai.exaleap.common.vo.BaseVo;
import lombok.Data;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 13:55 on 2018/10/16.
 */
@Data
public class StoreStockOverdueVo implements BaseVo {

    /**
     * 超期天数
     */
    private Integer overdueCount;
    /**
     * 车型名称
     */
    private String styleFullName;
    /**
     * 上牌日期
     */
    private String regDate;
    /**
     * 行驶里程
     */
    private String mileage;
    /**
     * 车辆状态
     */
    private String vehicleStatus;
    /**
     * 分销价
     */
    private String toBPrice;
    /**
     * 分销价
     */
    private String toCPrice;
    /**
     * 入库日期
     */
    private String storageDate;
}
