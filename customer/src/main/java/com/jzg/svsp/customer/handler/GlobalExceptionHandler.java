package com.jzg.svsp.customer.handler;


import com.jzg.svsp.common.vo.ResultVo;
import com.jzg.svsp.common.vo.RetStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 所有异常报错
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ResultVo allExceptionHandler(HttpServletRequest request,
                                        Exception exception) throws Exception {
        ResultVo resultVo = new ResultVo();
        resultVo.setStatus(RetStatus.Exception.getValue());
        resultVo.setMsg("服务器异常，请联系管理员！");
        log.error("服务端异常 ：", exception);
        return resultVo;
    }

}