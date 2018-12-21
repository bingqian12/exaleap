package ai.exaleap.common.enums;

public enum CommonStatusEnum {
    STATUS_ENABLE(0,"启用"),
    STATUS_DISABLE(1,"禁用"),
    OTHER(10, "其他");

        /**
         * value
         */
        private int value;

        /**
         * text
         */
        private String text;

        /**
         * 构造方法
         *
         * @param value 状态码
         * @param text  文字说明
         */
        CommonStatusEnum(int value, String text) {
            this.value = value;
            this.text = text;
        }

        public static CommonStatusEnum getCommonStatusEnum(int value) {
            for (CommonStatusEnum cs :CommonStatusEnum.values()) {
                if (cs.getValue() == value) {
                    return cs;
                }
            }
            return CommonStatusEnum.OTHER;
        }

        public static CommonStatusEnum getCommonStatusEnum(String value) {
            for (CommonStatusEnum cs : CommonStatusEnum.values()) {
                if (cs.getText().equals(value)) {
                    return cs;
                }
            }
            return CommonStatusEnum.OTHER;
        }

        /**
         * 获取value
         *
         * @return 状态码
         */
        public int getValue() {
            return this.value;
        }

        /**
         * 获取说明
         *
         * @return 文字说明
         */
        public String getText() {
            return this.text;
        }
}
