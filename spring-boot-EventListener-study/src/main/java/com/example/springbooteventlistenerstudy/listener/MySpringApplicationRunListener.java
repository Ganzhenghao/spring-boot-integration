package com.example.springbooteventlistenerstudy.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/19 18:00
 */

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    //必须添加这个构造方法
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
    }

    @Override
    public void starting() {
        System.out.println("项目开始启动  starting......");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("环境对象开始准备 environmentPrepared......");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("上下文对象开始准备 contextPrepared.......");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("上下文对象开始加载 contextLoaded.... ");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("上下文对象加载完成 started  ..........");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("项目开始运行 running...");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("项目启动失败 failed .... ");
    }
}
