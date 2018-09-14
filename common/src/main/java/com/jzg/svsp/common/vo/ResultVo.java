package com.jzg.svsp.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * ajax调用统一返回该结果
 *
 * 返回信息
 */
public class ResultVo<T extends Serializable> extends BaseResultVo implements Serializable {
    private static final long serialVersionUID = 4712972757347990461L;

    private T data = null;

    private List<T> list = null;

    /**
     * 获取返回对象
     *
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * 设置返回对象
     *
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

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
