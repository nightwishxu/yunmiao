package com.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import redis.clients.util.Pool;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Jedis客户端工具类
 * 
 * @author lilin
 * @version [版本号, 2015年2月3日]
 */
@SuppressWarnings("unchecked")
@Component
public class JedisTemplate<T> {
    /**
     * UTF-8字符集
     */
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    
    /**
     * redis连接池
     */
    @Resource(name = "jedisPool")
    private Pool<Jedis> pool;
    
    /**
     * 
     * 
     * @param key key
     * @return 结果
     */
    public Boolean exists(final String key) {
        return (Boolean)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.exists(key);
            }
        });
    }
    
    /**
     * 设置k-v数据
     * 
     * @param key key
     * @param value value
     * @return 结果
     */
    public String set(final String key, final String value) {
        return (String)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.set(key, value);
            }
        });
    }
    
    /**
     * 设置k-v数据，第二个参数必须实现Serializable接口
     * 
     * @param key key
     * @param value value
     * @return 结果
     */
    public String set(final String key, final Object value) {
        return (String)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.set(key.getBytes(UTF_8), Jdkserializers.toSerialization(value));
            }
        });
    }
    
    /**
     * 设置一个会失效的k-v数据
     * 
     * @param key key
     * @param value value
     * @param seconds 多少秒后失效
     * @return 结果
     */
    public String setex(final String key, final String value, final int seconds) {
        return (String)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.setex(key, seconds, value);
            }
        });
    }
    
    /**
     * 设置一个会失效的k-v数据，第二个参数必须实现Serializable接口
     * 
     * @param key key
     * @param value value
     * @param seconds 多少秒后失效
     * @return 结果
     */
    public String setex(final String key, final Object value, final int seconds) {
        return (String)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.setex(key.getBytes(UTF_8), seconds, Jdkserializers.toSerialization(value));
            }
        });
    }
    
    /**
     * 为key设置生存时间
     * 
     * @param key key
     * @param seconds 多少秒后失效
     * @return 结果
     */
    public long expire(final String key, final int seconds) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.expire(key, seconds);
            }
        });
    }
    
    /**
     * 根据key获取String类型value
     * 
     * @param key key
     * @return value
     */
    public String get(final String key) {
        return (String)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.get(key);
            }
        });
    }
    
    /**
     * 根据key获取对象类型value
     * 
     * @param key key
     * @return value
     */
    public T getObj(final String key) {
        return (T)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return Jdkserializers.fromSerialization(jedis.get(key.getBytes(UTF_8)));
            }
        });
    }
    
    /**
     * 根据key获取对象类型value
     * 
     * @param key key
     * @return value
     */
    public List<T> getObjs(final String[] key) {
        return (List<T>)execute(new JedisCallback() {
            @Override
            public List<Object> doInRedis(Jedis jedis) {
                List<Object> objectList = new ArrayList<Object>();
                byte[][] keys = new byte[key.length][];
                for (int j = 0; j < key.length; j++) {
                    keys[j] = key[j].getBytes(UTF_8);
                }
                
                List<byte[]> objList = jedis.mget(keys);
                for (int i = 0; i < objList.size(); i++) {
                    byte[] obj = objList.get(i);
                    objectList.add(Jdkserializers.fromSerialization(obj));
                }
                return objectList;
            }
        });
    }
    
    /**
     * 设置hashmap
     * 
     * @param key key
     * @param field 字段名
     * @param value 字段值
     * @return long
     */
    public Long hset(final String key, final String field, final String value) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.hset(key, field, value);
            }
        });
    }
    
    /**
     * 获取hashmap中的value
     * 
     * @param key key
     * @param field 字段名
     * @return 字段值
     */
    public String hget(final String key, final String field) {
        return (String)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.hget(key, field);
            }
        });
    }
    
    /**
     * 删除hashmap中的fields
     * 
     * @param key key
     * @param fields 字段名数组
     * @return 删除数量
     */
    public Long hdel(final String key, final String... fields) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.hdel(key, fields);
            }
        });
    }
    
    /**
     * 设置set
     * 
     * @param key key
     * @param field 字段名
     * @param value 字段值
     * @return long
     */
    public Long sadd(final String key, final String value) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.sadd(key, value);
            }
        });
    }
    
    /**
     * 批量移除set
     * 
     * @param key key
     * @param field 字段名
     * @param value 字段值
     * @return long
     */
    public Long sremBatch(final String key, final String[] fields) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.srem(key, fields);
            }
        });
    }
    
    /**
     * 移除set
     * 
     * @param key key
     * @param field 字段名
     * @param value 字段值
     * @return long
     */
    public Long srem(final String key, final String fields) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.srem(key, fields);
            }
        });
    }
    
    /**
     * 获取set中的value
     * 
     * @param key key
     * @param field 字段名
     * @return 字段值
     */
    public Set<String> smembers(final String key) {
        return (Set<String>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.smembers(key);
            }
        });
    }
    
    /**
     * 为哈希表 key 中的域 field 的值加上增量 increment 。
     * 
     * @param key key value
     * @param field 字段名
     * @return 字段值
     */
    public Long hincrby(final String key, final String field, final Long value) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.hincrBy(key, field, value);
            }
        });
    }
    
    /**
     * 为哈希表 key 中的域 field 的值加上增量 increment 。
     * 
     * @param key key value
     * @param field 字段名
     * @return 字段值
     */
    public Double hincrByFloat(final String key, final String field, final Double value) {
        return (Double)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.hincrByFloat(key, field, value);
            }
        });
    }
    
    /**
     * 批量获取hashmap的值
     * 
     * @param key key
     * @param fields 字段名集合
     * @return value集合
     */
    public List<String> hmget(final String key, final String... fields) {
        return (List<String>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.hmget(key, fields);
            }
        });
    }
    
    /**
     * 获取hashmap的键值
     * 
     * @param key key
     * @return map
     */
    public Map<String, String> hgetAll(final String key) {
        return (Map<String, String>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.hgetAll(key);
            }
        });
    }
    
    /**
     * 批量设置hashmap中的key-value
     * 
     * @param key key
     * @param field 字段名
     * @return 字段值
     */
    public String hmset(final String key, final Map<String, String> map) {
        return (String)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.hmset(key, map);
            }
        });
    }
    
    /**
     * 从栈顶入栈
     * 
     * @param key key
     * @param values 值
     * @return long
     */
    public Long lpush(final String key, final String... values) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.lpush(key, values);
            }
        });
    }
    
    /**
     * 从栈底入栈
     * 
     * @param key key
     * @param values 值
     * @return long
     */
    public Long rpush(final String key, final String... values) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.rpush(key, values);
            }
        });
    }
    
    /**
     * 从栈顶入栈
     * 
     * @param key key
     * @param values 值
     * @return long
     */
    public Long lpush(final String key, final Object... values) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                byte[][] objArr = new byte[values.length][];
                for (int i = 0; i < values.length; i++) {
                    objArr[i] = Jdkserializers.toSerialization(values[i]);
                }
                return jedis.lpush(key.getBytes(UTF_8), objArr);
            }
        });
    }
    
    /**
     * 从栈底入栈
     * 
     * @param key key
     * @param values 值
     * @return long
     */
    public Long rpush(final String key, final Object... values) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                byte[][] objArr = new byte[values.length][];
                for (int i = 0; i < values.length; i++) {
                    objArr[i] = Jdkserializers.toSerialization(values[i]);
                }
                return jedis.rpush(key.getBytes(UTF_8), objArr);
            }
        });
    }
    
    /**
     * 从栈顶出栈
     * 
     * @param key key
     * @return String
     */
    public String lpopStr(final String key) {
        return (String)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.lpop(key);
            }
        });
    }
    
    /**
     * 从栈底出栈
     * 
     * @param key key
     * @return String
     */
    public String rpopStr(final String key) {
        return (String)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.rpop(key);
            }
        });
    }
    
    /**
     * 从栈顶出栈
     * 
     * @param key key
     * @return Object
     */
    public T lpopObj(final String key) {
        return (T)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return Jdkserializers.fromSerialization(jedis.lpop(key.getBytes(UTF_8)));
            }
        });
    }
    
    /**
     * 从栈底出栈
     * 
     * @param key key
     * @return Object
     */
    public T rpopObj(final String key) {
        return (T)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return Jdkserializers.fromSerialization(jedis.rpop(key.getBytes(UTF_8)));
            }
        });
    }
    
    /**
     * 从队列左边的start位置取到end位置的数据列表
     * 
     * @param key key
     * @param start 起始索引
     * @param end 结束索引（闭区间）
     * @return List<Object>
     */
    public List<T> lrangeObj(final String key, final long start, final long end) {
        return (List<T>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                List<byte[]> byteList = jedis.lrange(key.getBytes(UTF_8), start, end);
                List<T> objList = new ArrayList<T>(byteList.size());
                for (byte[] value : byteList) {
                    objList.add((T)Jdkserializers.toSerialization(value));
                }
                return objList;
            }
        });
    }
    
    /**
     * 从队列左边的start位置取到end位置的数据列表
     * 
     * @param key key
     * @param start 起始索引
     * @param end 结束索引（闭区间）
     * @return List<Object>
     */
    public List<String> lrangeStr(final String key, final long start, final long end) {
        return (List<String>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.lrange(key, start, end);
            }
        });
    }
    
    /**
     * 将 key 中储存的数字值增一
     * 
     * @param key key
     * @return 执行结果
     */
    public Long incr(final String key) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.incr(key);
            }
        });
    }
    
    /**
     * 将 key 中储存的数字值减一
     * 
     * @param key key
     * @return 执行结果
     */
    public Long decr(final String key) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.decr(key);
            }
        });
    }
    
    /**
     * 获取redis锁
     * 
     * @param key key
     * @param seconds 多少秒后失效
     * @return true/false
     */
    public boolean getLock(final String key, final int seconds) {
        boolean result = setnx(key, "1") == 1;
        if (result) {
            expire(key, seconds);
        }
        return result;
    }
    
    /**
     * 释放redis锁
     * 
     * @param key key
     */
    public void releaseLock(final String key) {
        del(key);
    }
    
    /**
     * set-not-exist
     * 
     * @param key key
     * @param value value
     * @return 1成功（不存在）0失败（存在）
     */
    public Long setnx(final String key, final String value) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.setnx(key, value);
            }
        });
    }
    
    /**
     * 删除某个key
     * 
     * @param keys keys
     * @return 删除成功个数
     */
    public Long del(final String... keys) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.del(keys);
            }
        });
    }
    
    /**
     * 将member元素及其score值加入到有序集key当中
     * 
     * @param key key
     * @param score score
     * @param member member
     * @return 添加成功的个数
     */
    public Long zadd(final String key, final double score, final String member) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zadd(key, score, member);
            }
        });
    }
    
    /**
     * 批量将member元素及其score值加入到有序集key当中
     * 
     * @param key key
     * @param scoreMembers scoreMembers
     * @return 添加成功的个数
     */
    public Long zadd(final String key, final Map<String, Double> scoreMembers) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zadd(key, scoreMembers);
            }
        });
    }
    
    /**
     * 获取成员的score
     *
     * @param key key
     * @param member member
     * @return score
     */
    public Double zscore(final String key, final String member) {
        return (Double)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zscore(key, member);
            }
        });
    }
    
    /**
     * 获取成员的排名，按 score 值从小到大排序。
     *
     * @param key key
     * @param member member
     * @return score
     */
    public Long zrank(final String key, final String member) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrank(key, member);
            }
        });
    }
    
    /**
     * 获取成员的排名，按 score 值从大到小排序。
     *
     * @param key key
     * @param member member
     * @return score
     */
    public Long zrevrank(final String key, final String member) {
        return (Long)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrevrank(key, member);
            }
        });
    }
    
    /**
     * 为有序集 key 的成员 member 的 score 值加上增量 increment。<br>
     * 可以通过传递一个负数值 increment ，让 score 减去相应的值，比如 ZINCRBY key -5 member ，就是让member 的 score 值减去 5 。<br>
     * 当 key 不存在，或 member 不是 key 的成员时， ZINCRBY key increment member 等同于 ZADD key increment member。<br>
     * 当 key 不是有序集类型时，返回一个错误。
     * 
     * @param key key
     * @param score score
     * @param member member
     * @return member 成员的新 score 值
     */
    public Double zincrby(final String key, final double score, final String member) {
        return (Double)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zincrby(key, score, member);
            }
        });
    }
    
    /**
     * 返回有序集 key 中，指定区间内的成员和score，从小到大排序
     * 
     * @param key key
     * @param start 起始值
     * @param end 结束值
     * @return 有序集合
     */
    public Set<Tuple> zrangeWithScores(final String key, final long start, final long end) {
        return (Set<Tuple>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrangeWithScores(key, start, end);
            }
        });
    }
    
    /**
     * 从小到大返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员包含成员和score
     * 
     * @param key key
     * @param min min
     * @param max max
     * @param offset 偏移量
     * @param count 数量
     * @return 有序集合
     */
    public Set<Tuple> zrangeByScoreWithScores(final String key, final double min, final double max, final int offset,
        final int count) {
        return (Set<Tuple>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrangeByScoreWithScores(key, min, max, offset, count);
            }
        });
    }
    
    /**
     * 从小到大返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员
     * 
     * @param key key
     * @param min min
     * @param max max
     * @param offset 偏移量
     * @param count 数量
     * @return 有序集合
     */
    public Set<String> zrangeByScore(final String key, final double min, final double max, final int offset,
        final int count) {
        return (Set<String>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrangeByScore(key, min, max, offset, count);
            }
        });
    }
    
    /**
     * 从小到大返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员和score
     * 
     * @param key key
     * @param min min
     * @param max max
     * @return 有序集合
     */
    public Set<Tuple> zrangeByScoreWithScores(final String key, final double min, final double max) {
        return (Set<Tuple>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrangeByScoreWithScores(key, min, max);
            }
        });
    }
    
    /**
     * 从小到大返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员
     * 
     * @param key key
     * @param min min
     * @param max max
     * @return 有序集合
     */
    public Set<String> zrangeByScore(final String key, final double min, final double max) {
        return (Set<String>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrangeByScore(key, min, max);
            }
        });
    }
    
    /**
     * 返回有序集 key 中，指定区间内的成员和score，从大到小排序
     * 
     * @param key key
     * @param start 起始值
     * @param end 结束值
     * @return 有序集合
     */
    public Set<Tuple> zrevrangeWithScores(final String key, final long start, final long end) {
        return (Set<Tuple>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrevrangeWithScores(key, start, end);
            }
        });
    }
    
    /**
     * 从大到小返回有序集 key 中，所有 score 值介于 max 和 min 之间(包括等于 min 或 max )的成员和score
     * 
     * @param key key
     * @param max max
     * @param min min
     * @param offset 偏移量
     * @param count 数量
     * @return 有序集合
     */
    public Set<Tuple> zrevrangeByScoreWithScores(final String key, final double max, final double min,
        final int offset, final int count) {
        return (Set<Tuple>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
            }
        });
    }
    
    /**
     * 从大到小返回有序集 key 中，所有 score 值介于 max 和 min 之间(包括等于 min 或 max )的成员和score
     * 
     * @param key key
     * @param max max
     * @param min min
     * @return 有序集合
     */
    public Set<Tuple> zrevrangeByScoreWithScores(final String key, final double max, final double min) {
        return (Set<Tuple>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrevrangeByScoreWithScores(key, max, min);
            }
        });
    }
    
    /**
     * 从大到小返回有序集 key 中，所有 score 值介于 max 和 min 之间(包括等于 min 或 max )的成员
     * 
     * @param key key
     * @param max max
     * @param min min
     * @param offset 偏移量
     * @param count 数量
     * @return 有序集合
     */
    public Set<String> zrevrangeByScore(final String key, final double max, final double min, final int offset,
        final int count) {
        return (Set<String>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrevrangeByScore(key, max, min, offset, count);
            }
        });
    }
    
    /**
     * 从大到小返回有序集 key 中，所有 score 值介于 max 和 min 之间(包括等于 min 或 max )的成员
     * 
     * @param key key
     * @param max max
     * @param min min
     * @return 有序集合
     */
    public Set<String> zrevrangeByScore(final String key, final double max, final double min) {
        return (Set<String>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrevrangeByScore(key, max, min);
            }
        });
    }


    
    /**
     * 返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量。
     * 
     * @param key key
     * @param min min
     * @param max max
     * @return 个数
     */
    public Integer zcount(final String key, final double min, final double max) {
        return (Integer)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zcount(key, min, max);
            }
        });
    }
    
    /**
     * 执行redis命令
     * 
     * @param callback 回调函数，执行redis命令
     * @return 执行结果
     */
    public Object execute(JedisCallback callback) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return callback.doInRedis(jedis);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * 从大到小返回有序集key,排名在 star 和end 之间
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> zrevrange(final String key, final long start, final long end){
        return (Set<String>)execute(new JedisCallback() {
            @Override
            public Object doInRedis(Jedis jedis) {
                return jedis.zrevrange(key, start, end);
            }
        });
    }
    
}
