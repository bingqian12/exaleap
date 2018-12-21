package ai.exaleap.common.vo.vehicle;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 19:04 on 2018/10/16.
 */
@Data
public class VehicleSearchParamVo {
    private Integer storeId;
    private String vinCode;
    private List<String> storeIds;
    private List<String> excludeStoreIds;
    private Integer shelfStatus;
    private Integer vehicleStatus;
    private Integer saleStatus;
    private Integer libraryStatus;
    private String createTime;
    private String shelfTime;
    private Integer viewNum;
    private Integer locationProvinceId;
    private Integer auditStatus;
    private String submitAuditTimeStart;
    private String submitAuditTimeEnd;
    private Integer pageNo;
    private Integer pageSize;
    private String carLicense;
    private String styleFullName;
    private Integer mileageStart;
    private Integer mileageEnd;
    private String dealerName;
    private BigDecimal startPrice;
    private BigDecimal endPrice;
    private Integer proviceId;
    private Integer modelId;
    private Integer limitStart;
    private Integer limitEnd;
    private Long vehicleId;
    private List<Long> excludeId;
    private String vehicleBusinessId;
    private String shelfApplyId;
}
