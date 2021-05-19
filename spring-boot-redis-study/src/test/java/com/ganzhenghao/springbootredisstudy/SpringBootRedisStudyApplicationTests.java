package com.ganzhenghao.springbootredisstudy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ganzhenghao.springbootredisstudy.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

@SpringBootTest
@Slf4j
class SpringBootRedisStudyApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Autowired
    private  ObjectMapper mapper;

    @Test
    public void one() {
        redisTemplate.boundValueOps("name").set("张三");
        log.info(redisTemplate.boundValueOps("name").get());
    }

    @Test
    public void two() throws JsonProcessingException {
        String json = mapper.writeValueAsString(new User("李白", 18));
        redisTemplate.boundValueOps("user2").set(json);
        log.info(redisTemplate.boundValueOps("user2").get());

    }

    @Test
    public void three() throws JsonProcessingException {
        for (int i = 0; i < 10; i++) {
            redisTemplate.boundListOps("users").rightPush(
                    mapper.writeValueAsString(new User("李白"+i, 18+i))
            );
        }
        for (int i = 0; i < redisTemplate.boundListOps("users").size(); i++) {
            log.info(redisTemplate.boundListOps("users").index(i));
        }

    }

    @Test
    public void four() {
        redisTemplate.boundHashOps("map").put("name", "张三");
        redisTemplate.boundHashOps("map").put("age", "18");
        Map<Object, Object> map = redisTemplate.boundHashOps("map").entries();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            log.info(entry.getKey() + " == " + entry.getValue());
        }

    }

    @Test
    public void five() {
        for (int i = 0; i < 10; i++) {
            redisTemplate.boundSetOps("set").add("李四");
        }
    }

}
