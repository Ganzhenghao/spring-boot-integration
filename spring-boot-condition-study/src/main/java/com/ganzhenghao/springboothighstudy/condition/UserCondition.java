package com.ganzhenghao.springboothighstudy.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * todo describe
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/19 10:34
 */
public class UserCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean flag = true;

        String[] classes = (String[]) metadata.getAnnotationAttributes(ConditionOnClass.class.getName()).get("value");

        try {
            for (String clazz : classes) {
                Class.forName(clazz);
            }
        } catch (ClassNotFoundException e) {
            flag = false;
        }

        return flag;
    }
}
