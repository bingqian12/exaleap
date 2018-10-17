package com.jzg.svsp.common.vo.stock;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

@Data
public class DealerStockWarnVo implements BaseVo {

    private Long id;

    private Long dealerId;

    private Integer stockAge;

    private Integer overdueDate;

    private Integer viewOverdueDate;

    private Integer viewNumber;

}