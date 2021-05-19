package com.ganzhenghao.springbootelasticsearchstudy.basicuser;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @ClassName ElasticSearchBasicUse
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/13 9:46
 * @Version 1.0
 */
public class ElasticSearchBasicUse_Doc_Query_Page {
    public static void main(String[] args) {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.44.149", 9200)));

        //条件查询
        SearchRequest request = new SearchRequest().indices("user");
        SearchRequest searchRequest = request.source(
                new SearchSourceBuilder()
                        .query(QueryBuilders.matchAllQuery())
                        .from(0)
                        .size(2)
        );
        SearchResponse resp = null;
        try {
            resp = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SearchHits hits = null;
        if (resp != null) {
            hits = resp.getHits();
            hits.forEach(documentFields -> System.out.println(documentFields.getSourceAsString()));
        }

        //关闭客户端
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
