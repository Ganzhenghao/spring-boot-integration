package com.ganzhenghao.springbootwebstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/7/16 14:45
 */
@RestController
public class IPController {

    @RequestMapping("/getIP")
    public String getIP(HttpServletRequest request) {

        return request.getRemoteAddr();
    }
}
