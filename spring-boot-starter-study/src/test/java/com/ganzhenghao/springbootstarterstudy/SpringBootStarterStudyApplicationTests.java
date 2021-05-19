package com.ganzhenghao.springbootstarterstudy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class SpringBootStarterStudyApplicationTests {

    @Autowired
    private Jedis jedis;

    @Test
    void contextLoads() {
        jedis.set("name", "zhangsan");
    }

}
