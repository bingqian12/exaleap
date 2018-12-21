package ai.exaleap.common.vo.login;

import ai.exaleap.common.vo.BaseVo;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:16 on 2018/9/18.
 */
public class LoginParamVo implements BaseVo {
    private String mobile;
    private String validateCode;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }
}
