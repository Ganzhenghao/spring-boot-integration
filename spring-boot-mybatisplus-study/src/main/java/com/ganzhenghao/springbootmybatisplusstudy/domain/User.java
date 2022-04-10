package com.ganzhenghao.springbootmybatisplusstudy.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/29 10:24
 */
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@TableName("mp_user")
public class User extends Model<User> {
    //主键ID
    private Long id;
    //姓名
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String name;
    //年龄
    @NonNull
    private Integer age;
    //邮箱
    @NonNull
    private String email;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Long version;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer deleted;

}