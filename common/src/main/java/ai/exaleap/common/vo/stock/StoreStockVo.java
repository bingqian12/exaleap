package ai.exaleap.common.vo.stock;

import ai.exaleap.common.vo.BaseVo;
import lombok.Data;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 11:18 on 2018/10/12.
 */
@Data
public class StoreStockVo implements BaseVo {

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
}
