package com.example.springbootbeansearchstudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootbeansearchstudy.entity.User;
import com.example.springbootbeansearchstudy.mapper.UserMapper;
import com.example.springbootbeansearchstudy.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author ADS
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-05-05 10:41:56
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




