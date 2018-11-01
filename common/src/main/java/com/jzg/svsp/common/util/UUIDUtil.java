package com.jzg.svsp.common.util;

import java.util.UUID;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/25 10:13
 * @notes:
 */
public class UUIDUtil {
    /**
     * 生成ID
     *
     * @return
     */
    public static String getRandomId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
