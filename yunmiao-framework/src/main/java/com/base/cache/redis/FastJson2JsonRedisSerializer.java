package com.base.cache.redis;

import java.nio.charset.Charset;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJson2JsonRedisSerializer implements RedisSerializer<Object>{

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	
	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		return deserialize(bytes, Object.class);
	}

	@Override
	public byte[] serialize(Object t) throws SerializationException {
		 if (t == null) {
	            return new byte[0];
	        }
		 return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
	}
	
	/**
	 * @param source can be {@literal null}.
	 * @param type must not be {@literal null}.
	 * @return {@literal null} for empty source.
	 * @throws SerializationException
	 */
	public <T> T deserialize(byte[] source, Class<T> type) throws SerializationException {

		Assert.notNull(type,
				"Deserialization type must not be null! Pleaes provide Object.class to make use of Jackson2 default typing.");
		if (source == null || source.length <= 0) {
            return null;
        }
		String data = new String(source,DEFAULT_CHARSET);
		T t = JSON.parseObject(data,type);
		return t;
	}

}
