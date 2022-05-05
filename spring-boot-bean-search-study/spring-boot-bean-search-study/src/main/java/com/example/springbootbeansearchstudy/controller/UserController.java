package com.example.springbootbeansearchstudy.controller;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springbootbeansearchstudy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2022/5/5 10:42
 */
@RestController
@RequestMapping("/user")
public class UserController {


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

    @RequestMapping("/getUser")
    public ResponseEntity<Object> getUser(HttpServletRequest request){

        Map<String, Object> flat = MapUtils.flat(request.getParameterMap());
        SearchResult<Map<String, Object>> search = mapSearcher.search(User.class, flat);

        return ResponseEntity.ok().body(search);
    }

}
