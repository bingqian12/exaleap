package com.jzg.svsp.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ajax调用统一返回该结果
 *
 * 返回信息
 */
@Data
public class ResultVo<T extends Serializable> extends BaseResultVo implements Serializable {
    private static final long serialVersionUID = 4712972757347990461L;

    private T data = null;


    public ResultVo() {
        super();
    }

    public ResultVo(int status) {
        super(status);
    }

    public ResultVo(int status, String msg) {
        super(status, msg);
    }
}
