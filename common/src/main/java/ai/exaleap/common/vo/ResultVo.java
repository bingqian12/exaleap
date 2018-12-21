package ai.exaleap.common.vo;

import lombok.Data;
import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * ajax调用统一返回该结构
 * <p>
 * 返回信息
 */
@Data
public class ResultVo<T> extends BaseResultVo implements Serializable {
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

    public boolean succeed() {
        return getStatus() == HttpStatus.SC_OK;
    }
}
