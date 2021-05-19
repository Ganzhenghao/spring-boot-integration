package com.ganzhenghao.springbootmybatisstudy.dao;
import com.ganzhenghao.springbootmybatisstudy.domain.User;

import java.util.List;

/**
 * todo describe
 * @author Ganzhenghao
 * @date 2021/5/18 15:54
 * @version 1.0
 */
public interface UserDao {

    int insert(User record);

    List<User> findAll();



}