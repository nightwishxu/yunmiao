package com.base.cache.redis;

import java.util.Collection;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBatisRedisCache implements Cache {

	private static Logger logger = LoggerFactory.getLogger(MyBatisRedisCache.class);

	/** The ReadWriteLock. */
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
	private final String id;
	private final String COMMON_CACHE_KEY = "COM:";
	/**
	 * 按照一定规则标识key
	 */
	private String getKey(Object key) {
		StringBuilder accum = new StringBuilder();
		accum.append(COMMON_CACHE_KEY);
		accum.append(this.id).append(":");
		accum.append(DigestUtils.md5Hex(String.valueOf(key)));
		return accum.toString();
	}

	/**
	 * redis key规则前缀
	 */
	private String getKeys() {
		return COMMON_CACHE_KEY + this.id + ":*";
	}

	public MyBatisRedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("必须传入ID");
		}
		//jedisConnectionFactory = SpringContextUtil.getBean(JedisConnectionFactory.class);
		logger.debug("MybatisRedisCache:id=" + id);
		this.id = id;
	}

	@Override
	public void clear() {
		ReditClient.deleteKeys(getKeys());
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Object getObject(Object key) {
        Object value = ReditClient.get(getKey(key));
        return value;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	@Override
	public int getSize() {
		Collection<String> set = ReditClient.keys(getKeys());
		return set.size();
	}

	@Override
	public void putObject(Object key, Object value) {
		ReditClient.set(getKey(key), value);
	}

	@Override
	public Object removeObject(Object key) {
		ReditClient.delete(getKey(key));
		logger.debug("LRU算法从缓存中移除-----" + this.id);
        Object value = null;
        return value;
	}

}
