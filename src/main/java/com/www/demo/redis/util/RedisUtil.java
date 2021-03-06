package com.www.demo.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author www
 * @version 1.0
 * @description redis工具类
 * @date 2021/6/27 16:07
 */
@Component
public final class RedisUtil {
    private static RedisTemplate<String,Object> redisTemplate;
    /**
     * @author www
     * @date 2021/6/30 22:56
     * @description 返回redisTemplate实例
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.String, java.lang.Object>
     */
    public static RedisTemplate<String,Object> getRedisTemplate(){
        return redisTemplate;
    }
    /**
     * @author www
     * @date 2021/6/27 16:42
     * @description 判断key值是否存在
     * @param key 键值
     * @return boolean
     */
    public static boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }
    /**
     * @Author www
     * @Date 2021/5/26 21:18
     * @Description 保存String数据
     * @param key 键值
     * @param value 值
     */
    public static Object set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
        return value;
    }
    /**
     * @Author www
     * @Date 2021/5/26 21:18
     * @Description 获取String数据
     * @param key 键值
     * @return java.lang.Object
     */
    public static Object get(String key){
        Object value = redisTemplate.opsForValue().get(key);
        return value;
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存Hash数据
     * @param key 键值
     * @param okey 对象键值
     * @param value 值
     * @return value
     */
    public static Object hashSet(String key, String okey, Object value){
        redisTemplate.opsForHash().put(key,okey,value);
        return value;
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取存储在哈希表中指定字段的值
     * @param key 键值
     * @param okey 对象字段
     * @return Object
     */
    public static Object hashGet(String key, String okey){
        return redisTemplate.opsForHash().get(key,okey);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取在哈希表中指定 key 的所有字段和值
     * @param key 键值
     * @return Object
     */
    public static Object hashGet(String key){
        return redisTemplate.opsForHash().values(key);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 从左边保存List数据
     * @param key 键值
     * @param value 值
     * @return Object
     */
    public static Object listSet(String key, Object value){
        redisTemplate.opsForList().leftPush(key,value);
        return value;
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取List集合中所有数据
     * @param key 键值
     * @return java.lang.Object
     */
    public static Object listGet(String key){
        return redisTemplate.opsForList().range(key,0,-1);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存Set数据
     * @param key 键值
     * @param value 值
     * @return Object
     */
    public static Object setSet(String key, Object value){
       redisTemplate.opsForSet().add(key,value);
        return value;
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 返回Set集合中的所有数据
     * @param key 键值
     * @return java.lang.Object
     */
    public static Object setGet(String key){
        return redisTemplate.opsForSet().members(key);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存ZSet数据
     * @param key 键值
     * @param value 值
     * @param score 分值
     * @return Object
     */
    public static Object zsetSet(String key, Object value, double score){
        redisTemplate.opsForZSet().add(key,value,score);
        return value;
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取ZSet数据
     * @param key 键值
     * @return java.lang.Object
     */
    public static Object zsetGet(String key){
        return redisTemplate.opsForZSet().range(key,0,-1);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }
}
