package com.ganzhenghao.springbootmybatisplusstudy.controller;


import com.ganzhenghao.springbootmybatisplusstudy.entity.User;
import com.ganzhenghao.springbootmybatisplusstudy.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author Ganzhenghao
 * @since 2021-04-06 15:24:40
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


}
