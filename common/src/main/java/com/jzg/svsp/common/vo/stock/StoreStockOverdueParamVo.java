package com.jzg.svsp.common.vo.stock;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 15:51 on 2018/10/16.
 */
@Data
public class StoreStockOverdueParamVo implements BaseVo{

    private Integer pageNo;

    private Integer pageSize;

    private Integer stockAge;

    private Integer overdueDate;

    private Integer viewOverdueDate;

    private Integer viewNumber;

    private String storeId;

    private Integer locationProvinceId;
}
