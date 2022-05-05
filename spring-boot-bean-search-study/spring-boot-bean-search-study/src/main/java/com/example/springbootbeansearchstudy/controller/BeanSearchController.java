package com.example.springbootbeansearchstudy.controller;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.MapSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2022/5/5 10:08
 */
@RestController
@RequestMapping("/bean")
public class BeanSearchController {

    /**
     * 注入 Map 检索器，它检索出来的数据以 Map 对象呈现
     */
    @Autowired
    private MapSearcher mapSearcher;
    /**
     * 注入 Bean 检索器，它检索出来的数据以 泛型 对象呈现
     */
    @Autowired
    private BeanSearcher beanSearcher;

    @RequestMapping("/search")
    public String search() {
        return "search";
    }



}
