package com.ganzhenghao.springbootmongodbstudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/6/3 11:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    private String city;
    private String zip;
}