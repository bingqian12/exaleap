package com.jzg.svsp.common.vo.login;

import com.jzg.svsp.common.vo.BaseVo;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:26 on 2018/9/18.
 */
public class SendValidateCodeParamVo implements BaseVo{
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
