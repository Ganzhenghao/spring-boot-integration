package com.ganzhenghao.springbootelasticsearchstudy.basicuser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName ElasticSearchBasicUse
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/13 9:46
 * @Version 1.0
 */
public class ElasticSearchBasicUse_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.44.149", 9200)));

        BulkRequest request = new BulkRequest();
        ObjectMapper mapper = new ObjectMapper();
        request.add(new IndexRequest()
                .index("user")
                .id("1001")
                .source(mapper.writeValueAsString(new User("张三","男",23)), XContentType.JSON));
        request.add(new IndexRequest()
                .index("user")
                .id("1002")
                .source(mapper.writeValueAsString(new User("李四","男",24)), XContentType.JSON));
        request.add(new IndexRequest()
                .index("user")
                .id("1003")
                .source(mapper.writeValueAsString(new User("周星星","女",28)), XContentType.JSON));
        request.add(new IndexRequest()
                .index("user")
                .id("1004")
                .source(mapper.writeValueAsString(new User("周七","女",28)), XContentType.JSON));
        request.add(new IndexRequest()
                .index("user")
                .id("1005")
                .source(mapper.writeValueAsString(new User("赵六","男",28)), XContentType.JSON));
        request.add(new IndexRequest()
                .index("user")
                .id("1006")
                .source(mapper.writeValueAsString(new User("黑皮","男",15)), XContentType.JSON));

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println("response.getTook() = " + response.getTook());
        System.out.println("response.getItems() = " + Arrays.toString(response.getItems()));
        System.out.println("response.status() = " + response.status());
        //关闭客户端
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
