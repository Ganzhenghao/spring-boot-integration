package com.example.springbootvalidator;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class SpringBootValidatorApplicationTests {

    @Test
    void contextLoads() {

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put(null, "2222");
        hashMap.put("null", "111");
        System.out.println(hashMap);
        System.out.println(hashMap.get(null));
    }

    /**
     * 将时间戳转换为10位时间戳
     */
    @Test
    void test() {

        //当前时间
        DateTime date = DateUtil.date();
        System.out.println(date.toString("yyyy-MM-dd HH:mm:ss"));
        // 增加10分钟
        date.offset(DateField.MINUTE, 10);
        System.out.println(date.toString("yyyy-MM-dd HH:mm:ss"));
        // 当前时间戳
        System.out.println(date.getTime());
        // 转为10位时间戳
        long addTime = date.getTime() / 1000;
        System.out.println(addTime);
        // 转回当前时间
        DateTime dateTime = DateUtil.date(addTime * 1000);
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));


    }


}
