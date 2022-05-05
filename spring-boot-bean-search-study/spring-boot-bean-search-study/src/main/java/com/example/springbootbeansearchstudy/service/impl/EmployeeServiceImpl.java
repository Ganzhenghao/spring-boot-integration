package com.example.springbootbeansearchstudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootbeansearchstudy.entity.Employee;
import com.example.springbootbeansearchstudy.mapper.EmployeeMapper;
import com.example.springbootbeansearchstudy.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
* @author ADS
* @description 针对表【employee】的数据库操作Service实现
* @createDate 2022-05-05 10:18:09
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

}




