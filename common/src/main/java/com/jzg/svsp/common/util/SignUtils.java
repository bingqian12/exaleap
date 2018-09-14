package com.jzg.svsp.common.util;




import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;

/**
 * Created by JZG on 2017/4/27.
 */
@Slf4j
public class SignUtils {


    /**
     * 生成签名
     *
     * @param paramMap 参数
     * @param appKey   密钥
     * @return 新签名
     */
    public static String generateSign(Map<String, Object> paramMap, String appKey) {
        String newSign = null;
        //应用私钥
        try {
            StringBuffer stringBuffer = new StringBuffer("");
            Set<String> keySet = paramMap.keySet();
            String[] keyArr = keySet.toArray(new String[]{});
            QuickSort.sort(keyArr, 0, keyArr.length - 1); // 获取所有参数名，并排序
            for (String paramKey : keyArr) {
                if (!"sign".equals(paramKey)) {
                    stringBuffer.append(paramKey);
                    stringBuffer.append("=");
                    stringBuffer.append(paramMap.get(paramKey));
                }
            }
            stringBuffer.append(appKey.toLowerCase());
            String paramStr = stringBuffer.toString().toLowerCase();
            log.info("paramStr=>" + paramStr);
            newSign = Md5Encrypt.toHexString(Md5Encrypt.encrypt(paramStr, "UTF-8"));
            log.info("sign=>" + paramStr);
        } catch (Exception e) {
            log.error("[third-party-core][generateSign]发生异常", e);
        }
        return newSign;
    }
}
