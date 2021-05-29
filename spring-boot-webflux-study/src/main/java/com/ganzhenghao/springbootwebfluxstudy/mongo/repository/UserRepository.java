package com.ganzhenghao.springbootwebfluxstudy.mongo.repository;

import com.ganzhenghao.springbootwebfluxstudy.mongo.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/22 20:26
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
