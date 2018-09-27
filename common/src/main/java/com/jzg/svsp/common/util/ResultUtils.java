package com.jzg.svsp.common.util;


import com.jzg.svsp.common.enums.HttpStatusEnum;
import com.jzg.svsp.common.vo.ResultPageVo;
import com.jzg.svsp.common.vo.ResultVo;

import java.io.Serializable;

public class ResultUtils {

    public static ResultVo success(Serializable data) {
        return success(data, HttpStatusEnum.OK.code(), HttpStatusEnum.OK.reasonPhraseCN());
    }


    public static ResultVo success(Serializable data, int status, String message) {

        ResultVo resultVo = new ResultVo();
        resultVo.setStatus(status);
        resultVo.setMsg(message);
        resultVo.setData(data);
        return resultVo;

    }


    public static ResultVo fail(int status, String errorMsg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setStatus(status);
        resultVo.setMsg(errorMsg);
        return resultVo;

    }

    public static ResultPageVo resultPageVofail(int status, String errorMsg) {
        ResultPageVo resultVo = new ResultPageVo();
        resultVo.setStatus(status);
        resultVo.setMsg(errorMsg);
        return resultVo;

    }
}
