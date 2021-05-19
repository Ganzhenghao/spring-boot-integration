package com.ganzhenghao.springbootelasticsearchstudy.springbootes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @ClassName Product
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/18 21:18
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "product",shards = 3, replicas = 1)
public class Product {
    @Id
    private Long id;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Keyword)
    private String category;
    @Field(type = FieldType.Double)
    private Double price;
    @Field(type = FieldType.Text,index = false)
    private String images;
}
