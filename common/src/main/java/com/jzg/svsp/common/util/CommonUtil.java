package com.jzg.svsp.common.util;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
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
     * 转化为不为空的类型String
     *
     * @param value
     * @return
     */
    public static String getNonNullStringZero(Object value) {

        if (value != null) {
            return String.valueOf(value);
        }
        return "0";
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
        for (String str : value) {
            res += str + ",";
        }
        return res.substring(0, res.length() - 1);
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

    private static final BigDecimal THOUSAND = new BigDecimal(10000);

    public static String formatMileage(String mileage) {
        if (StringUtils.isBlank(mileage)) {
            return "";
        }
        return formatMileage(Integer.valueOf(mileage));
    }

    public static String formatMileage(Integer mileage) {
        if (mileage == null) {
            return "";
        }
        return new BigDecimal(mileage).divide(THOUSAND).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }

}