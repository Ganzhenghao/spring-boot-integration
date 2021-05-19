package com.ganzhenghao.springbootelasticsearchstudy.basicuser;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @ClassName ElasticSearchBasicUse
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/13 9:46
 * @Version 1.0
 */
public class ElasticSearchBasicUse_Doc_Delete {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.44.149", 9200)));


        DeleteRequest request = new DeleteRequest().index("user").id("1001");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
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
