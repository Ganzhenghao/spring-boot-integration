package com.ganzhenghao.springsecuritystudy.service;

import com.ganzhenghao.springsecuritystudy.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * todo describe
 * @author Ganzhenghao
 * @date 2021/5/16 16:25
 * @version 1.0
 */
public interface UserService extends IService<User>{


        boolean login(String username, String password);


    }
