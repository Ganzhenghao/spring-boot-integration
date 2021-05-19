package com.ganzhenghao.springbootadminclientstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/19 19:50
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/findAll")
    public String findAll() {
        return "success!";
    }

}
