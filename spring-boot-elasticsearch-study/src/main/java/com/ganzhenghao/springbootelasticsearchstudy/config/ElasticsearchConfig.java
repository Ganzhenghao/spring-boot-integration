package com.ganzhenghao.springbootelasticsearchstudy.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @ClassName ElasticsearchConfig
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/4/18 21:11
 * @Version 1.0
 */
@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {


    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("192.168.44.149:9200")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

}
