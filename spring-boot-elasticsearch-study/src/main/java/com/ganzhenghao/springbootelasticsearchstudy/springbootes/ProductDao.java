package com.ganzhenghao.springbootelasticsearchstudy.springbootes;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ProductDao
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/19 19:03
 * @Version 1.0
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product,Long> {

}
