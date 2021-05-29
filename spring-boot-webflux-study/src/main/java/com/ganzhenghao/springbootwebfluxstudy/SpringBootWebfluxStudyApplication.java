package com.ganzhenghao.springbootwebfluxstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringBootWebfluxStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebfluxStudyApplication.class, args);
    }

}
