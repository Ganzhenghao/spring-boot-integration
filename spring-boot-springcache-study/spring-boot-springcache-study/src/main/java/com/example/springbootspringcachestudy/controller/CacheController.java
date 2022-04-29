package com.example.springbootspringcachestudy.controller;

import com.example.springbootspringcachestudy.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2022/4/29 9:47
 */
@RestController
@RequestMapping("cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("get/{key}")
    public ResponseEntity<Object> getCache(@PathVariable String key) {
        return ResponseEntity.ok(cacheService.get(key));
    }

    @GetMapping("put/{key}/{value}")
    public ResponseEntity<Object> putCache(@PathVariable String key, @PathVariable String value) {
        return ResponseEntity.ok().body(cacheService.put(key, value));
    }

    @GetMapping("del/{key}")
    public ResponseEntity<Object> delCache(@PathVariable String key) {
        return ResponseEntity.ok().body(cacheService.delete(key));
    }


}
