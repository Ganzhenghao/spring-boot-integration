package com.ganzhenghao.springbootmybatisstudy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * todo describe
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/18 16:00
 */
@Configuration
@MapperScan("com.ganzhenghao.springbootmybatisstudy.dao")
public class MybatisConfig {


}
