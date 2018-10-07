package com.base.cache.redis;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

import com.base.spring.SpringContextUtil;

public class ReditClient {

	@SuppressWarnings("unchecked")
	private static RedisTemplate<String, Object> redisTemplate = SpringContextUtil.getBean(RedisTemplate.class);

	public static void setRedisTemplate(
			RedisTemplate<String, Object> redisTemplate) {
		ReditClient.redisTemplate = redisTemplate;
	}
	
	/** 
     * 读取缓存 
     *  
     * @param key 
     * @param clazz 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> T get(final String key, Class<T> clazz) {  
        return (T) redisTemplate.boundValueOps(key).get();  
    } 

	/* ----------- common --------- */
	public static Collection<String> keys(String pattern) {
		return redisTemplate.keys(pattern);
	}
	
	public static void deleteKeys(String pattern){
		Collection<String> key = keys(pattern);
		delete(key);
	}
	
	/** 
     * key是否存在 
     *  
     * @param key 
     */  
    public static boolean exists(final String key) {  
        return redisTemplate.hasKey(key);  
    }  
	
	 /** 
     * 删除，根据key精确匹配 
     *  
     * @param key 
     */  
    public static void del(final String... key) {  
        redisTemplate.delete(Arrays.asList(key));  
    } 

	public static void delete(String key) {
		redisTemplate.delete(key);
	}

	public static void delete(Collection<String> key) {
		redisTemplate.delete(key);
	}

	/* ----------- string --------- */
	public static Object get(String key) {
		Object value = redisTemplate.opsForValue().get(key);
		return value;
	}

	public static void set(String key, Object obj) {
		set(key, obj, null);
	}

	public static void set(String key, Object obj, Long timeout) {
		if (obj == null) {
			return;
		}
		redisTemplate.opsForValue().set(key, obj);

		if (timeout != null) {
			redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
		}
	}

}
