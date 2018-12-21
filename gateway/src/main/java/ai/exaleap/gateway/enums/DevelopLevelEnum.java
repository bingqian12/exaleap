package ai.exaleap.gateway.enums;

/**
 * Created by Dara on 2017/3/2.
 * 发送短信模版编码
 */
public enum DevelopLevelEnum {

    /**
     * 部署级别
     */
    DEV("dev", 1),
    LOCAL("local", 2),
    PROD("prod", 3),
    TEST("test", 4),
    ;

    private String value;
    private int code ;
    private DevelopLevelEnum(String value, int code){
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public int getCode() {
        return code;
    }
}
