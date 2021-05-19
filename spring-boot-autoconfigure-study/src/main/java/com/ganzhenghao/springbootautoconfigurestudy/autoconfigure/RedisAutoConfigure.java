package com.ganzhenghao.springbootautoconfigurestudy.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * todo describe
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/19 16:42
 */
@EnableConfigurationProperties(RedisProperties.class)
@Configuration
@ConditionalOnClass(Jedis.class)
public class RedisAutoConfigure {


    @Bean
    @ConditionalOnMissingBean(name = "jedis")
    public Jedis jedis(RedisProperties redisProperties) {
        System.out.println("my onw redis create...");
        return new Jedis(redisProperties.getHost(),redisProperties.getPort());
    }


}
