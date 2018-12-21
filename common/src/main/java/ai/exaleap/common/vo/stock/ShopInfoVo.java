package ai.exaleap.common.vo.stock;

import ai.exaleap.common.vo.BaseVo;
import lombok.Data;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:13 on 2018/10/17.
 */
@Data
public class ShopInfoVo implements BaseVo {
    private Long id;
    private String shopName;
    private Integer provId;
    private Integer cityId;
    private String address;
    private Integer marketId;
    private String marketName;
    private String marketAddress;
    private String busName;
    private String contPhone;
}
