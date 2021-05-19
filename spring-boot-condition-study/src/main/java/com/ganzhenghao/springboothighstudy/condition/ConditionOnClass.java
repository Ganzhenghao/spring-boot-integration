package com.ganzhenghao.springboothighstudy.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * todo describe
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/19 10:36
 */
@Conditional(UserCondition.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConditionOnClass {

    String[] value();

}
