package ai.exaleap.common.vo.vehicle;

import ai.exaleap.common.vo.BaseVo;
import lombok.Data;

import java.util.Date;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 16:02 on 2018/10/26.
 */
@Data
public class DealerAccnumVo implements BaseVo {

    private Long id;

    private Long dealerId;

    private Long busDealerId;

    private String actName;

    private String actLogin;

    private Integer actRole;

    private Integer sex;

    private String wechat;

    private String tradeImId;

    private String tradeImPass;

    private String headPortraitUrl;

    private Date createTime;

    private Date updateTime;

    private String operator;

    private Integer actStatus;

}
