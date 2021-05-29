package com.ganzhenghao.springbootmybatisplusstudy.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganzhenghao.springbootmybatisplusstudy.dao.UserDao;
import com.ganzhenghao.springbootmybatisplusstudy.domain.User;
import com.ganzhenghao.springbootmybatisplusstudy.service.impl.UserService;
/**
 * 
 * @author Ganzhenghao
 * @date 2021/5/29 10:20
 * @version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService{

}
