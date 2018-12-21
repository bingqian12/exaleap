package ai.exaleap.common.vo.vehicle;

import ai.exaleap.common.vo.report.CheckItems;
import ai.exaleap.common.vo.BaseVo;
import lombok.Data;

import java.util.List;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 16:56 on 2018/10/25.
 */
@Data
public class CheckResult implements BaseVo{

    private String checkProject;
    private List<CheckItems> checkItems;
    private String diagrammaticLink;
    private String description;



}
