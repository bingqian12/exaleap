package com.jzg.svsp.common.util;


import com.alibaba.fastjson.JSONObject;
import com.jzg.svsp.common.enums.HttpStatusEnum;
import com.jzg.svsp.common.vo.ResultListVo;
import com.jzg.svsp.common.vo.ResultPageVo;
import com.jzg.svsp.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import java.io.Serializable;

@Slf4j
public class ResultUtils {

    public static ResultVo success(Serializable data) {
        return success(data, HttpStatusEnum.OK.code(), HttpStatusEnum.OK.reasonPhraseCN());
    }


    public static ResultVo success(Object data, int status, String message) {

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

    public static ResultVo fail(int status, String errorMsg,Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setStatus(status);
        resultVo.setMsg(errorMsg);
        resultVo.setData(data);
        return resultVo;

    }

    public static ResultListVo listSuccess(List list, int status, String errorMsg) {
        ResultListVo resultVo = new ResultListVo();
        resultVo.setStatus(status);
        resultVo.setMsg(errorMsg);
        resultVo.setList(list);
        return resultVo;

    }

    public static ResultListVo resultListFail(int status, String errorMsg) {
        ResultListVo resultVo = new ResultListVo();
        resultVo.setStatus(status);
        resultVo.setMsg(errorMsg);
        return resultVo;

    }

    public static ResultPageVo resultPageVoFail(int status, String errorMsg) {
        ResultPageVo resultVo = new ResultPageVo();
        resultVo.setStatus(status);
        resultVo.setMsg(errorMsg);
        return resultVo;

    }

    public static ResultVo changeResultListVo(ResultListVo resultListVo) {
        ResultVo resultVo = new ResultVo();
        resultVo.setStatus(resultListVo.getStatus());
        resultVo.setMsg(resultListVo.getMsg());
        resultVo.setData(resultListVo.getList());
        return resultVo;
    }

    public static ResultVo changeResultPageVo(ResultPageVo resultPageVo) {
        ResultVo resultVo = new ResultVo();
        JSONObject data = new JSONObject();
        data.put("pageNo", resultPageVo.getPageNo());
        data.put("pageSize", resultPageVo.getPageSize());
        data.put("pageCount", resultPageVo.getPageCount());
        data.put("total", resultPageVo.getTotal());
        data.put("list", resultPageVo.getList());
        resultVo.setStatus(resultPageVo.getStatus());
        resultVo.setMsg(resultPageVo.getMsg());
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo resultPageFail(int status, String errorMsg) {
        ResultVo resultVo = new ResultVo();
        JSONObject data = new JSONObject();
        data.put("pageNo", 1);
        data.put("pageSize", 10);
        data.put("pageCount", 0);
        data.put("total", 0);
        data.put("list", null);
        resultVo.setStatus(status);
        resultVo.setMsg(errorMsg);
        resultVo.setData(data);
        return resultVo;
    }
}
