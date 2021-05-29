package com.ganzhenghao.springbootelasticsearchstudy.basicuser;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @ClassName ElasticSearchBasicUse
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/13 9:46
 * @Version 1.0
 */
public class ElasticSearchBasicUse_Index_Create {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.44.149", 9200)));

        //创建索引
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("user");
        CreateIndexResponse response = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        //响应状态
        boolean acknowledged = response.isAcknowledged();
        System.out.println("是否成功 = " + acknowledged);
        //关闭客户端
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
