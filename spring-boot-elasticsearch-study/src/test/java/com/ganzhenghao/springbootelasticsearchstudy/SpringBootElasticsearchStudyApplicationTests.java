package com.ganzhenghao.springbootelasticsearchstudy;

import com.ganzhenghao.springbootelasticsearchstudy.springbootes.Product;
import com.ganzhenghao.springbootelasticsearchstudy.springbootes.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.Optional;
import java.util.stream.Stream;

@SpringBootTest
@Slf4j
class SpringBootElasticsearchStudyApplicationTests {

    @Autowired
    private ElasticsearchRestTemplate template;

    @Autowired
    private ProductDao productDao;


    /**
     * 创建索引
     */
    @Test
    public void createIndex() {
        //系统初始化会自动创建索引
        log.info("索引创建成功!");
    }


    /**
     * 删除索引
     */
    @Test
    public void deleteIndex() {
        log.info("索引删除");
        template.deleteIndex(Product.class);
    }


    /**
     * 保存产品
     */
    @Test
    public void saveProduct() {

        //单个保存
        Product product = new Product();
        product.setId(2L);
        product.setTitle("华为手机");
        product.setCategory("手机");
        product.setPrice(6999.0D);
        product.setImages("https://g-picture.oss-cn-chengdu.aliyuncs.com/markdown/1617780054551.png");
        productDao.save(product);

    }

    /**
     * 更新产品  id相同 保存就是更新
     */
    @Test
    public void updateProduct() {

        Product product = new Product();
        product.setId(1L);
        product.setTitle("小米手机");
        product.setCategory("手机");
        product.setPrice(2999.0D);
        product.setImages("https://g-picture.oss-cn-chengdu.aliyuncs.com/markdown/1617780054551.png");
        productDao.save(product);
    }

    /**
     * 根据id查询数据
     */
    @Test
    public void findById() {
        Optional<Product> productOptional = productDao.findById(1L);
        Product product = productOptional.orElseThrow();
        System.out.println("product = " + product);
    }

    /**
     * 找到所有
     */
    @Test
    public void findAll() {
        Iterable<Product> all = productDao.findAll();
        for (Product next : all) {
            System.out.println(next);
        }
    }

    /**
     * 排序后分页查询
     */
    @Test
    public void selectByPageAndSort() {
        // ASC ==> 升序排列  DESC 降序排列
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        int currentPage = 0; //当前页 从第一页从0开始
        int pageSize = 5; //每页显示数据

        PageRequest page = PageRequest.of(currentPage, pageSize,sort);
        Page<Product> all = productDao.findAll(page);
        Stream<Product> productStream = all.get();
        productStream.forEach(System.out::println);

    }

    /**
     * 删除
     */
    @Test
    public void delete() {
        //根据id删除
        productDao.deleteById(2L);

        //根据对象里不为空的属性删除
        Product product = new Product();
        product.setId(2L);
        productDao.delete(product);

        //删除所有
        productDao.deleteAll();
    }


    @Test
    public void termSearch() {
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "小");


        Iterable<Product> search = productDao.search(termQueryBuilder);

        search.forEach(System.out::println);

    }




}
