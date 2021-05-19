package com.ganzhenghao.springbootmybatisplusstudy.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)表实体类
 *
 * @author Ganzhenghao
 * @since 2021-04-06 10:49:25
 */
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User extends Model<User> {
    //主键ID
    private Long id;
    //姓名
    @NonNull
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
