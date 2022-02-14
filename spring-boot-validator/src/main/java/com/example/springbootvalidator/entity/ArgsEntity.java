package com.example.springbootvalidator.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2022/2/14 13:55
 */
@Data
public class ArgsEntity {

    @NotBlank(message = "名称为必填项")
    private String name;

    @Range(min = 1, max = 100, message = "年龄必须在1-100之间")
    private Integer age;

    @Size(min = 1, max = 3, message = "兴趣必须在1-2之间")
    private List<String> hobbies;

    @NotNull(message = "其他不能为空")
    private OtherEntity otherEntity;

}
