package ai.exaleap.common.vo.vehicle;

import ai.exaleap.common.vo.BaseVo;
import lombok.Data;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 15:10 on 2018/10/22.
 */
@Data
public class VehicleAuditParamVo implements BaseVo {

    private Long vehicleId;

    private Integer auditStatus;

    private String auditReason;
}
