package com.jzg.svsp.common.vo.stock;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:13 on 2018/10/17.
 */
@Data
public class ShopInfoVo implements BaseVo{
    private Long id;
    private String shopName;
    private Integer provId;
}
