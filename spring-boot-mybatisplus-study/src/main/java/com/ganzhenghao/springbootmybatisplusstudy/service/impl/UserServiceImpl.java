package com.ganzhenghao.springbootmybatisplusstudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganzhenghao.springbootmybatisplusstudy.dao.UserDao;
import com.ganzhenghao.springbootmybatisplusstudy.entity.User;
import com.ganzhenghao.springbootmybatisplusstudy.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author Ganzhenghao
 * @since 2021-04-06 15:24:40
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
