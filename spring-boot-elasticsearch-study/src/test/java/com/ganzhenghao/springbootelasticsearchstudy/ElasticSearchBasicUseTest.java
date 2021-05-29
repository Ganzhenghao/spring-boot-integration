package com.ganzhenghao.springbootelasticsearchstudy;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/23 14:59
 */

public class ElasticSearchBasicUseTest {

    private static RestHighLevelClient client;
    
    @BeforeAll
    public static void before() {
        //创建ES客户端
        client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.44.149", 9200)));
    }

    @AfterAll
    public static void after() {
        //关闭客户端
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createIndex() throws IOException {

    }
    
    


}
