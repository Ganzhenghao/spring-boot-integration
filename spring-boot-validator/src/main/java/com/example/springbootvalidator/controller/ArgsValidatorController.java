package com.example.springbootvalidator.controller;

import com.example.springbootvalidator.entity.ArgsEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2022/2/14 13:54
 */
@RestController
@RequestMapping("args")
public class ArgsValidatorController {

    @PostMapping("/validator")
    public ResponseEntity<String> validator(@Validated @RequestBody ArgsEntity argsEntity) {
        System.out.println(argsEntity);
        return ResponseEntity.ok("success");
    }
}
