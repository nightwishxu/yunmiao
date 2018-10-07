package com.base.cache.redis;

import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.base.exception.SystemException;

/**
 * 取redis 连接池  
 * <一句话功能简述>  
 * <功能详细描述>
 * @see  [相关类/方法]
 * @author sun  [产品/模块版本]  
 */
public class RedisClientPool {
	private static JedisConnectionFactory jedisConnectionFactory;
	
	public static JedisConnection getConnection(){
		if (jedisConnectionFactory == null){
			throw new SystemException("jedisConnectionFactory 初始化失败");
		}
		return (JedisConnection) jedisConnectionFactory.getConnection();
	}
	
	public static void releaseResource(JedisConnection connection){
		if (connection != null){
			connection.close();
		}
	}
	
	public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		RedisClientPool.jedisConnectionFactory = jedisConnectionFactory;
    }
}