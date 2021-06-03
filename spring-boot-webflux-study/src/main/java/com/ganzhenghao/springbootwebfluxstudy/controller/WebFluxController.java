package com.ganzhenghao.springbootwebfluxstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/22 20:15
 */
@RestController
@RequestMapping("/webflux")
@Slf4j
public class WebFluxController {


    @RequestMapping("/mvc")
    public String mvc() {
        log.info("传统MVC 开始处理请求 ...");
        String result = createString();
        log.info("传统MVC 处理完成 ...");
        return result;
    }


    @RequestMapping("/mono")
    public Mono<String> mono() {
        log.info("Webflux --> Mono 开始处理请求 ...");
        //Mono<String> mono = Mono.just(createString());
        Mono<String> mono = Mono.fromSupplier(this::createString);
        log.info("Webflux --> Mono 处理完成 ...");
        return mono;
    }

    @RequestMapping(value = "flux",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        log.info("Webflux --> Flux 开始处理请求 ...");
        Flux<String> flux = Flux.fromStream(IntStream.range(1, 10).mapToObj(value -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "WebFlux Data ==>  " + value;
        }));
        log.info("Webflux --> Flux 处理完成 ...");
        return flux;

    }


    /**
     * 创建字符串 模拟耗时操作
     *
     * @return {@link String}
     */
    private String createString() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "five seconds! ";
    }



}
