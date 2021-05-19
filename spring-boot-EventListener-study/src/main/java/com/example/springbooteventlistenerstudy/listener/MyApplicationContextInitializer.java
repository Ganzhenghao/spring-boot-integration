package com.example.springbooteventlistenerstudy.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * MyApplicationContextInitializer 监听类
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/19 17:58
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("MyApplicationContextInitializer ...");
    }
}
