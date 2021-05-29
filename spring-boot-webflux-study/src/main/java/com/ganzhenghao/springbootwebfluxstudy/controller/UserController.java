package com.ganzhenghao.springbootwebfluxstudy.controller;

import com.ganzhenghao.springbootwebfluxstudy.mongo.domain.User;
import com.ganzhenghao.springbootwebfluxstudy.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/22 20:36
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public Flux<User> findAll() {
        return userRepository.findAll();
    }


    @PostMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> findAllByStream() {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public Mono<User> saveOrUpdate(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {



        return userRepository.findById(id).
                flatMap(user -> userRepository.delete(user)
                    .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                    .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }




}
