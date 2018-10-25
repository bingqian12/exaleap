package com.jzg.svsp.common.util;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by JZG on 2017/6/12.
 */
public class CommonUtil {

    /**
     * 方法二：推荐，速度最快
     * 判断是否为整数
     *
     * @param str 传入的字符串
     * @return 是整数返回true, 否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

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

    /**
     * 时间戳
     */
    private static final String FORMAT = "yyyyMMddHHmmss";
    /**
     * 数字随机
     */
    public static final String NUMBER_CHAR = "0123456789";

    /**
     * 随机数字
     */
    public static final int NUMBER_RANDOM = 5;

    /**
     * 时间+随机数
     *
     * @return
     */
    public static synchronized String createOrderIdByTime(String prefix) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < NUMBER_RANDOM; i++) {
            sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
        }
        return prefix + sdf.format(new Date()) + sb.toString();
    }

    public static String createVehicleBusinessId(){
        return createOrderIdByTime("CT");
    }

    public static String createShelfApplyId(){
        return createOrderIdByTime("AS");
    }
}