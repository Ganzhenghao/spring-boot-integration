package com.ganzhenghao.springbootadminserverstudy;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringBootAdminServerStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminServerStudyApplication.class, args);
    }

}
