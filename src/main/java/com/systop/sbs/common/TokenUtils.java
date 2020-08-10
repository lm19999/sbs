package com.systop.sbs.common;



import com.systop.sbs.common.util.RedisUtils;

import java.util.UUID;

public class TokenUtils {
    /****/
    private static final String USER_TOKEN="user:token:";

    public static String createToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 保存用户信息，过期2小时
     * @param userInfo
     * @param token
     * @param <T>
     */
    public static <T> void saveUserInfo(T userInfo,String token){
        String key = USER_TOKEN+token;
        RedisUtils.put(key,userInfo,7200L);
    }
}
