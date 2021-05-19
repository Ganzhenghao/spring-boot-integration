package com.ganzhenghao.springsecuritystudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganzhenghao.springsecuritystudy.dao.UserDao;
import com.ganzhenghao.springsecuritystudy.domain.User;
import com.ganzhenghao.springsecuritystudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * todo describe
 * @author Ganzhenghao
 * @date 2021/5/16 16:25
 * @version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public boolean login(String username,String password){

        User user = userDao.findByUsername(username);

        return true;
    }



}
