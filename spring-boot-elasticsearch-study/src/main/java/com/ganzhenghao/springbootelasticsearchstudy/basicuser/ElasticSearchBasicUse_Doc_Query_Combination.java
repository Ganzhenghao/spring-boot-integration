package com.ganzhenghao.springbootelasticsearchstudy.basicuser;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @ClassName ElasticSearchBasicUse
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/13 9:46
 * @Version 1.0
 */
public class ElasticSearchBasicUse_Doc_Query_Combination {
    public static void main(String[] args) {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.44.149", 9200)));

        //组合查询
        SearchRequest request = new SearchRequest().indices("user");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // must -> 必须匹配  should -->可以匹配
        //BoolQueryBuilder builder = QueryBuilders.boolQuery();
/*        builder.must(QueryBuilders.matchQuery("age", 28));
        builder.must(QueryBuilders.matchQuery("sex", "男"));*/
/*        builder.should(QueryBuilders.matchQuery("age", 28));
        builder.should(QueryBuilders.matchQuery("sex", "男"));*/

        //范围查询
/*        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
        RangeQueryBuilder builder = rangeQuery.gte(18);*/
        //RangeQueryBuilder builder = rangeQuery.from(15).to(28);

        //模糊查询
/*        FuzzyQueryBuilder builder =
                QueryBuilders.fuzzyQuery("name", "星星")
                        .fuzziness(Fuzziness.ONE);*/

        //高亮查询
/*        TermQueryBuilder builder = QueryBuilders.termQuery("name", "周");
        searchSourceBuilder.highlighter(new HighlightBuilder()
                .preTags("<font color='red'>")
                .postTags("</font>")
                .field("name"));
        searchSourceBuilder.query(builder);
        SearchRequest searchRequest = request.source(searchSourceBuilder);*/

        //聚合查询

/*        MaxAggregationBuilder max = AggregationBuilders.max("maxAge").field("age");
        searchSourceBuilder.aggregation(max);
        SearchRequest searchRequest = request.source(searchSourceBuilder);*/

        TermsAggregationBuilder ageGroup = AggregationBuilders.terms("ageGroup").field("age");
        searchSourceBuilder.aggregation(ageGroup);
        SearchRequest searchRequest = request.source(searchSourceBuilder);

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
