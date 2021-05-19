package com.ganzhenghao.springboothighstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootHighStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootHighStudyApplication.class, args);

        //如果没有导入jedis包就不会加载user
        Object user = context.getBean("user");

        System.out.println(user);


    }

}
