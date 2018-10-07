package com.base.cache.redis;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.base.spring.SpringContextUtil;

public class RedisCacheTransfer {
	
	private static JedisConnectionFactory jedisConnectionFactory = SpringContextUtil.getBean(JedisConnectionFactory.class);
	@SuppressWarnings("unchecked")
	private static RedisTemplate<String, Object> redisTemplate = SpringContextUtil.getBean(RedisTemplate.class);

    public void setJedisConnectionFactory() {
        RedisClientPool.setJedisConnectionFactory(jedisConnectionFactory);
    }
	
	public void setRedisTemplate(){
		ReditClient.setRedisTemplate(redisTemplate);
	}

	public JedisConnectionFactory getJedisConnectionFactory() {
		return jedisConnectionFactory;
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}
	
}
