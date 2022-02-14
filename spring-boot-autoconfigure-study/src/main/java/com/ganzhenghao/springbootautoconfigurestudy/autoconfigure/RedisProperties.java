package com.ganzhenghao.springbootautoconfigurestudy.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * todo describe
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/19 16:44
 */
@ConfigurationProperties("my.redis")
public class RedisProperties {

    private String host = "localhost";

    private int port = 6379;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
