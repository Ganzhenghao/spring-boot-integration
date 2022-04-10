/*
package com.ganzhenghao.springbootmybatisplusstudy;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ganzhenghao.springbootmybatisplusstudy.dao.UserDao;
import com.ganzhenghao.springbootmybatisplusstudy.domain.User;
import com.ganzhenghao.springbootmybatisplusstudy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringBootMybatisplusStudyApplicationTests {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }


    @Test
    public void insertData() {

        for (int i = 1; i <= 10; i++) {
            userDao.insert(new User("user:"+i, 20+i, "x@y.com"));
        }

    }

    @Test
    public void list() {
        List<User> users = userDao.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void selectBatchIds() {
        List<User> users = userDao.selectBatchIds(List.of(1, 3, 4));
        users.forEach(System.out::println);
    }

    @Test
    public void selectByMap() {
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("name", "狗比");
        List<User> users = userDao.selectByMap(hashMap);
        users.forEach(System.out::println);
    }

    @Test
    public void autoFill() {
        User user = new User( "girl", 18, "xxx@163.com");
        user.insert();
        System.out.println(user);
        user.setAge(18);
        user.setUpdateTime(null);
        user.updateById();
    }

    @Test
    public void logicDelete() {
        userDao.deleteById(7);
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("name", "狗比");
        userDao.deleteByMap(hashMap);
    }

    @Test
    public void lock() {

    }

    @Test
    public void page() {
        // 1 -> 第一页  3 -> 每页3条数据
        Page<User> userPage = new Page<>(1, 4);
        Page<User> page = userDao.selectPage(userPage, null);
        System.out.println("总页数-> page.getPages() = " + page.getPages());
        System.out.println("当前页-> page.getCurrent() = " + page.getCurrent());
        System.out.println("总记录数-> page.getTotal() = " + page.getTotal());
        System.out.println("是否有下一页-> page.hasNext() = " + page.hasNext());
        System.out.println("是否有上一页-> page.hasPrevious() = " + page.hasPrevious());
        System.out.println("每页几条数据-> page.getSize() = " + page.getSize());
        page.getRecords().forEach(System.out::println);
    }

    @Test
    public void queryWrapper1() {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "1398457723804213250,1398457728472473602,1398457728501833729");
        List<User> users = userDao.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void queryWrapper2() {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        */
/*
        1398457723804213250
        1398457728472473602
        1398457728501833729
        1398457728526999554
        1398457728543776769
        1398457728560553985

         *//*

        wrapper.inSql("id", "select id from mp_user");
        List<User> users = userDao.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void queryWrapper3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        String ids = "1398457723804213250,1398457728472473602,1398457728501833729";
        String[] split = ids.split(",");
        wrapper.in("id", Arrays.asList(split));
        List<User> users = userDao.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void lambdaQueryWrapper3() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getAge, 22);
        User one = userService.getOne(wrapper);
        System.out.println(one);
    }

}
*/
