package com.example.springbootbeansearchstudy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2022/5/5 10:51
 */
@Configuration
@MapperScan("com.example.springbootbeansearchstudy.mapper")
public class MybatisPlusConfig {
}

