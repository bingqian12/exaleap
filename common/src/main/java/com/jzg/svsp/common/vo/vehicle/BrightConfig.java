package com.jzg.svsp.common.vo.vehicle;

import com.jzg.svsp.common.vo.BaseVo;
import lombok.Data;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 20:43 on 2018/10/25.
 */
@Data
public class BrightConfig implements BaseVo{

    private String configId;
    private String configName;
    private String configImg;

    public BrightConfig(){}

    public BrightConfig(String configId,String configName,String configImg){
        this.configId = configId;
        this.configName = configName;
        this.configImg = configImg;
    }
}
