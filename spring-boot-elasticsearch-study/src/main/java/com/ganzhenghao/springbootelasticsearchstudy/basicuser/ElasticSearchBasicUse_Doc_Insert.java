package com.ganzhenghao.springbootelasticsearchstudy.basicuser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @ClassName ElasticSearchBasicUse
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/13 9:46
 * @Version 1.0
 */
public class ElasticSearchBasicUse_Doc_Insert {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.44.149", 9200)));

        //插入数据
/*        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");*/

        //简写 id --> return this;
        IndexRequest request = new IndexRequest().index("user").id("1001");

        //向ElasticSearch中插入数据 必须是 JSON 格式 也可以是map
        User user = new User("张三", "男", 18);
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);

        //将JSON写入请求体
        request.source(userJson, XContentType.JSON);

        //提交请求 返回响应
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println("response.getResult() = " + response.getResult());
        System.out.println("response.status() = " + response.status());

        //关闭客户端
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
