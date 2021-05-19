package com.ganzhenghao.springbootmybatisstudy.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ganzhenghao.springbootmybatisstudy.dao.UserDao;
import com.ganzhenghao.springbootmybatisstudy.domain.User;
import com.ganzhenghao.springbootmybatisstudy.service.UserService;
/**
 * todo describe
 * @author Ganzhenghao
 * @date 2021/5/18 15:54
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public int insert(User record) {
        return userDao.insert(record);
    }

}
