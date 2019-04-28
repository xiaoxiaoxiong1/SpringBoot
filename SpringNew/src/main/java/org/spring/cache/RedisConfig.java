package org.spring.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.LinkedList;
import java.util.List;

/**
 * @Created by Administrator on 2018/12/1.
 * @DESC
 * @DATE 01
 */
public class RedisConfig  extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager(@Autowired List<RedisCache> redisCaches) {
        SimpleCacheManager simpleCacheManager=new SimpleCacheManager();
        simpleCacheManager.setCaches(redisCaches);
        return simpleCacheManager;

    }


    @Bean
    @Order(1)
    public void newCache(@Autowired RedisTemplate redisTemplate){
        RedisCache redisCache=new RedisCache();
        redisCache.setRedisTemplate(redisTemplate);
        redisCache.setExpire("1000L");


    }


    @Bean
    @Order(2)
    public void newCache2(@Autowired RedisTemplate redisTemplate){

        RedisCache redisCache=new RedisCache();
        redisCache.setRedisTemplate(redisTemplate);
        redisCache.setExpire("1000L");


    }


}



