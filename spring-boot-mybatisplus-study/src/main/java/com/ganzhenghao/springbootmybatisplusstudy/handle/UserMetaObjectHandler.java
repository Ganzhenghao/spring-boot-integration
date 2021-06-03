package com.ganzhenghao.springbootmybatisplusstudy.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName UserMetaObjectHandler
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/6 10:51
 * @Version 1.0
 */
@Component
public class UserMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        System.out.println("插入时填充..................");
        // (工程mybatis-plus-study 里面有另一种写法)
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "version", Long.class,1L);

        //假设有个属性  某些表有 某些表没有 可以判断是否有该字段
        boolean exit = metaObject.hasSetter("某个属性");
        if (exit){
            //填充字段
            this.strictInsertFill(metaObject, "某个属性", LocalDateTime::now, LocalDateTime.class);
        }

        //假设有个属性 已经被赋值 不需要再次赋值 则可以判断 (基本类型可以被自动转换为Object类型)
        // TODO 这个方法是否可以被 metaObject里面的getValue方法替代
        Object value = this.getFieldValByName("某个属性",metaObject);
        if (value == null){
            //TODO 自动填充
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("更新时填充....................");
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }
}
