package com.ganzhenghao.springbootelasticsearchstudy;


import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ganzhenghao.springbootelasticsearchstudy.basicuser.User;
import org.junit.jupiter.api.Test;

/**
 * @ClassName ElasticSearchBasicUse
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/13 9:44
 * @Version 1.0
 */
public class ElasticSearchBasicUse {

    @Test
    public void testMethodName() {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setName("222");
        user.setSex("223332");
        user.setAge(11);
        try {
            System.out.println(mapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
