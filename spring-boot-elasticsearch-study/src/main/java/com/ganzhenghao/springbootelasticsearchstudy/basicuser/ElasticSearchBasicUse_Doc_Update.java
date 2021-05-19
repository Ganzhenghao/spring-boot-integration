package com.ganzhenghao.springbootelasticsearchstudy.basicuser;

import org.apache.http.HttpHost;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
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
public class ElasticSearchBasicUse_Doc_Update {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.44.149", 9200)));

        //全量跟新 --> 直接插入一个和原数据id相同的数据即可

        //局部更新
        UpdateRequest request = new UpdateRequest().index("user").id("1001");

        //doc()方法 有带 XContentType 参数的,也有不带的  不带的默认参数为XContentType.JSON
        //如果使用这种方式的传参 参数必须是偶数个 单数索引为字段名 双数索引为值
        //request.doc(XContentType.JSON,"sex","女");
        //request.doc("sex","男");
        //也可以使用Map进行传参 但是map的类型必须是 Map<String,Object> 不然就会调用Object参数的方法
        //Map<String,Object> map = new HashMap<>();
        //map.put("sex", "女");
        //request.doc(map);

        UpdateResponse resp = client.update(request, RequestOptions.DEFAULT);

        System.out.println("resp.getResult() = " + resp.getResult());

        //关闭客户端
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
