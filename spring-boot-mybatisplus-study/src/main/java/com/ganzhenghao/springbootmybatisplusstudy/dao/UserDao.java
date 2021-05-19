package com.ganzhenghao.springbootmybatisplusstudy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ganzhenghao.springbootmybatisplusstudy.entity.User;
import org.springframework.stereotype.Repository;

/**
 * (User)表数据库访问层
 *
 * @author Ganzhenghao
 * @since 2021-04-06 15:24:40
 */
@Repository
public interface UserDao extends BaseMapper<User> {

}
