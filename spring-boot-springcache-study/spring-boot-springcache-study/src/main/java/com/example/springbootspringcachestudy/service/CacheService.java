package com.example.springbootspringcachestudy.service;

import cn.hutool.core.util.RandomUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2022/4/29 9:54
 */
@Service
public class CacheService {

    private final String redisPrefix = "stu_cache";

    @Cacheable(value = redisPrefix, key = "#key", sync = true)
    public String get(String key) {
        return randomStr();
    }

    @CachePut(value = redisPrefix, key = "#key")
    public String put(String key, Object value) {
        return value.toString();
    }

    @CacheEvict(value = redisPrefix, key = "#key")
    public boolean delete(String key) {
        return true;
    }

    public String randomStr() {
        String str = RandomUtil.randomString(11);
        System.out.println(str);
        return str;
    }

}
