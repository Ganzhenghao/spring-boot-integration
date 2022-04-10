package com.ganzhenghao.springbootmybatisplusstudy.controller;

import com.ganzhenghao.springbootmybatisplusstudy.domain.User;
import com.ganzhenghao.springbootmybatisplusstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2022/3/3 16:36
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public String test(@RequestBody User user) {
        userService.save(user);
        return "success";
    }

    @PostMapping("/insertAllColumn")
    public ResponseEntity<Object> insertAllColumn(@RequestBody User user) {

        userService.updateById(user);

        return ResponseEntity.ok(null);
    }

    /**
     * 查询
     */
    @PostMapping("/select")
    public List<User> select() {
        return userService.list();
    }

}
