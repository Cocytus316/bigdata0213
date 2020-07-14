package com.atguigu.write;

import com.atguigu.bean.Movie;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.config.HttpClientConfig.Builder;
import io.searchbox.core.Index;

import java.io.IOException;

/**
 * @Author Ding Han
 * @Description
 * @create 2020-07-11 10:13
 * @Version 1.0
 */
public class ESWriter {
    public static void main(String[] args) throws IOException {
        //1.创建工厂
        JestClientFactory jestClientFactory = new JestClientFactory();

        //2.创建配置信息
        HttpClientConfig httpClientConfig = new Builder("http://hadoop102:9200").build();

        //3.设置配置信息
        jestClientFactory.setHttpClientConfig(httpClientConfig);

        //4.获取JestClient
        JestClient jestClient = jestClientFactory.getObject();

        //5.创建Index对象
        Movie movie = new Movie("0004", "独立日");
        Index index = new Index.Builder(movie).index("movie")
                .type("_doc")
                .id("1004")
                .build();

        //6.触发插入数据操作
        jestClient.execute(index);

        //7关闭资源
        jestClient.close();
    }
}
