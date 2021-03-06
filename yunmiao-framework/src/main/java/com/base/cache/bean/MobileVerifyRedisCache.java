package com.base.cache.bean;

import com.base.cache.redis.ReditClient;
import org.apache.commons.codec.digest.DigestUtils;

public class MobileVerifyRedisCache {

    private MobileVerifyRedisCache(){};

    private static final String COMMON_CACHE_KEY = "MOBILEVERIFY:";

    /**
     * 按照一定规则标识key
     */
    private static String getKey(Object key) {
        StringBuilder accum = new StringBuilder();
        accum.append(COMMON_CACHE_KEY);
        accum.append(DigestUtils.md5Hex(String.valueOf(key)));
        return accum.toString();
    }

    public static void set(String key, Object obj) {
        ReditClient.set(getKey(key), obj);
    }

    public static void setExpire(String key, Object obj) {
        set(key, obj, 1800L);
    }

    public static void set(String key, Object obj, Long timeout) {
        ReditClient.set(getKey(key), obj, timeout);
    }

    public static String get(String key) {
        return String.valueOf(ReditClient.get(getKey(key)));
    }
    public static <T> T get(String key, Class<T> clz) {
        return ReditClient.get(getKey(key),clz);
    }

    public static void delete(String key) {
        ReditClient.delete(key);
    }
}
