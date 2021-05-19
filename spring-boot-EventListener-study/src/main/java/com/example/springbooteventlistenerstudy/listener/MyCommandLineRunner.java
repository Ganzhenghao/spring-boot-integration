package com.example.springbooteventlistenerstudy.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/19 17:58
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        System.out.println("MyCommandLineRunner ...");


    }
}
