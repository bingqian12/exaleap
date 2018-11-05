package com.jzg.svsp.common.util;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
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

    public static String createVehicleBusinessId() {
        return createOrderIdByTime("CT");
    }

    public static String createShelfApplyId() {
        return createOrderIdByTime("AS");
    }

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }

            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }

        return obj;
    }

    /**
     * JavaBean对象转换为Map
     * @param obj
     * @return
     */
    public static Map<String, Object> convertObjToMap(Object obj){
        Map<String,Object> reMap = new HashMap<String,Object>();
        if (obj == null){
            return null;
        }

        try {
            Class<?> objClass = obj.getClass();
            while(objClass != null){
                Field[] fields = objClass.getDeclaredFields();
                for(int i=0;i<fields.length;i++){
                    try {
                        Field f = objClass.getDeclaredField(fields[i].getName());
                        f.setAccessible(true);
                        Object o = f.get(obj);
                        reMap.put(fields[i].getName(), o);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                objClass = objClass.getSuperclass();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return reMap;
    }

    public static Map<String, Object> objectToMap(Object obj)  {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (Exception e) {

            }
        }

        return map;
    }
}