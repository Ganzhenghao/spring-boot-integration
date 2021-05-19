package com.example.springbooteventlistenerstudy.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * todo describe
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/19 17:57
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner ....");
    }

}
