package com.example.springbootbeansearchstudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootbeansearchstudy.entity.Department;
import com.example.springbootbeansearchstudy.mapper.DepartmentMapper;
import com.example.springbootbeansearchstudy.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
* @author ADS
* @description 针对表【department】的数据库操作Service实现
* @createDate 2022-05-05 10:18:09
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{

}




