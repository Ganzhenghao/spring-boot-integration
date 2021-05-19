package com.ganzhenghao.springsecuritystudy.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ganzhenghao.springsecuritystudy.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * todo describe
 * @author Ganzhenghao
 * @date 2021/5/16 16:25
 * @version 1.0
 */
public interface UserDao extends BaseMapper<User> {

    User findByUsernameAndPassword(@Param("username")String username,@Param("password")String password);

    User findByUsername(@Param("username")String username);




}