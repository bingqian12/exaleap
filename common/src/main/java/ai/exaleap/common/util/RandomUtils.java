package ai.exaleap.common.util;

import java.util.Random;

/**
 * @Author: zhangcm
 * @Description:
 * @Date: Created by 16:37 on 2017/6/1.
 */
public final class RandomUtils {
    /**
     * 最大值
     */
    private static final int MAX_VALUE = 999999;
    /**
     * 最小值
     */
    private static final int MIN_VALUE = 100000;

    /**
     *
     */
    private RandomUtils(){ }

    /**
     * 生成6位验证码
     *
     * @return
     */
    public static String getValidateCode(){
        Random random = new Random();
        String valicode = (random.nextInt(MAX_VALUE) % (MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE) + "";
        return valicode;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        System.out.println(getValidateCode());
    }

}
