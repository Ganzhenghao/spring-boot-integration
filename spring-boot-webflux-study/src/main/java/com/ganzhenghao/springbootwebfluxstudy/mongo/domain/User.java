package com.ganzhenghao.springbootwebfluxstudy.mongo.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/22 20:22
 */
@Document(collection = "user")
@Data
public class User {
    @MongoId
    private String id;

    private String name;

    private Integer age;

}
