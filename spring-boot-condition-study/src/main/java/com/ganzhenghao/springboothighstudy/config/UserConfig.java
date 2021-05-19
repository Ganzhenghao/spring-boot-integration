package com.ganzhenghao.springboothighstudy.config;

import com.ganzhenghao.springboothighstudy.condition.ConditionOnClass;
import com.ganzhenghao.springboothighstudy.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo describe
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/19 10:09
 */
@Configuration
public class UserConfig {


    @Bean
    @ConditionOnClass("redis.clients.jedis.Jedis")
    public User user() {
        return new User();
    }

}
