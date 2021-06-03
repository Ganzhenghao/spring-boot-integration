package com.ganzhenghao.springbootmybatisplusstudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganzhenghao.springbootmybatisplusstudy.dao.UserDao;
import com.ganzhenghao.springbootmybatisplusstudy.domain.User;
import com.ganzhenghao.springbootmybatisplusstudy.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/29 10:20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

