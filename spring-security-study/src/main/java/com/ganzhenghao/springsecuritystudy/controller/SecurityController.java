package com.ganzhenghao.springsecuritystudy.controller;

import com.ganzhenghao.springsecuritystudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * todo describe
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/16 15:08
 */
@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username,String password){
        boolean login = userService.login(username, password);
        if (login){
            return "success";
        }else{
            return "false";
        }

    }





}
