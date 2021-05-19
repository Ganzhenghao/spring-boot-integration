package com.ganzhenghao.springbootdevstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * todo describe
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/13 10:51
 */
@Controller
@RequestMapping("/spring")
public class SpringBootDevController {


    @RequestMapping("/dev")
    public String toDev() {

        return "spring-dev";
    }

}
