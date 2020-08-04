package com.systop.sbs.common.util;

import java.util.Random;

/**
 * @Program: com.systop.sbs.common.util
 * @Description: TODO
 * @Author: ZhangLi
 * @Date: 2020/8/3 14:21
 **/
public class ComFunctionUtils {
    /**
     * 生成指定位数的随机数
     *
     * @param len 随机数长度[4，6]
     * @return 随机数
     */
    public static String generateRandom(Integer len) {
        String result;
        String ran = String.valueOf(System.nanoTime());
        if (len != null) {
            if (len < 4 || len > 6) {
                return null;
            }
            result = ran.substring(6, ran.length() + len - 8);
        } else {
            //不指定长度，生成六位随机数
            result = ran.substring(6, ran.length() - 2);
        }
        if (result.startsWith("0")) {
            result = "1" + result.substring(1);
        }
        return result;
    }

    /**
     * 生成随机数
     *
     * @param len 随机数长度
     * @return
     */
    public static String createRandom(Integer len) {
        if (len == null) {
            return null;
        }
        if (len < 4 || len > 6) {
            return null;
        }
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int ran = random.nextInt(10);
            if (i == 0) {
                ran = ran == 0 ? 1 : ran;
            }
            builder.append(ran);
        }
        System.out.println(builder);
        return builder.toString();
    }
}
