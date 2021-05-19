package com.ganzhenghao.springbootelasticsearchstudy.basicuser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/13 11:17
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;

    private String sex;

    private Integer age;
}
