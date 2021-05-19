package com.ganzhenghao.springbootmybatisstudy;

import com.ganzhenghao.springbootmybatisstudy.dao.UserDao;
import com.ganzhenghao.springbootmybatisstudy.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMybatisStudyApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {

    }

    @Test
    public void one() {
        userDao.insert(new User(null,"zhangsan","123"));
    }

    @Test
    public void two() {
        userDao.findAll().forEach(System.out::println);
    }

}
