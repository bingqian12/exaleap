package com.jzg.svsp.common.util;

import org.apache.commons.lang.StringUtils;
import java.util.List;

/**
 * Created by JZG on 2017/6/12.
 */
public class CommonUtil {

    /**
     * 转化为不为空的类型String
     *
     * @param value
     * @return
     */
    public static String getNonNullString(Object value) {

        if (value != null) {
            return String.valueOf(value);
        }
        return "";
    }

    /**
     * list 转化为string
     *
     * @param value
     * @return
     */
    public static String getNonNullStringForList(List<String> value) {
        String res = "";
        if (value == null || value.size() == 0) {
            return res;
        }
        for(String str:value){
            res += str +",";
        }
        return res.substring(0,res.length() -1);
    }


    /**
     * 转化为不为空的类型int
     *
     * @param value
     * @return
     */
    public static int getNonNullInt(String value) {
        try {
            if (StringUtils.isNotBlank(value)) {
                return Integer.valueOf(value);
            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }





    /**
     * 转化为不为空的类型int
     *
     * @param value
     * @return
     */
    public static double getNonNullDouble(String value) {
        try {
            if (StringUtils.isNotBlank(value)) {
                return Double.valueOf(value);
            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }


}