package com.atguigu.write;

import com.atguigu.bean.Movie;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.config.HttpClientConfig.Builder;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;

import java.io.IOException;

/**
 * @Author Ding Han
 * @Description
 * @create 2020-07-11 11:46
 * @Version 1.0
 */
public class ESWriteByBulk {

    public static void main(String[] args) throws IOException {

        //1.创建工厂
        JestClientFactory jestClientFactory = new JestClientFactory();

        //2.创建配置信息
        HttpClientConfig httpClientConfig = new Builder("hadoop102").build();

        //3.设置配置信息
        jestClientFactory.setHttpClientConfig(httpClientConfig);

        //4.获取客户端对象
        JestClient jestClient = jestClientFactory.getObject();

        //5.创建多个Index对象
        Movie mov1 = new Movie("0005", "钢铁侠");
        Movie mov2 = new Movie("0006", "肖申克的救赎");
        Movie mov3 = new Movie("0007", "阿甘正传");

        Index index1 = new Index.Builder(mov1).id("1005").build();
        Index index2 = new Index.Builder(mov2).id("1006").build();
        Index index3 = new Index.Builder(mov3).id("1007").build();

        //6.创建Bulk对象
        Bulk.Builder builder = new Bulk.Builder()
                .addAction(index1)
                .addAction(index2)
                .addAction(index3)
                .defaultIndex("movie")
                .defaultType("_doc");

        Bulk bulk = builder.build();

        //7.执行批量插入数据操作
        jestClient.execute(bulk);

        //8.关闭资源
        jestClient.close();
    }
}
