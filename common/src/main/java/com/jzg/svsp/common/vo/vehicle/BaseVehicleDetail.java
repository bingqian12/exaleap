package com.jzg.svsp.common.vo.vehicle;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

import java.util.List;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 14:22 on 2018/10/26.
 */
@Data
public class BaseVehicleDetail implements BaseVo{

    private String checkProject;
    private List<String> descriptions;
    private List<CheckResult> checkResults;
}
