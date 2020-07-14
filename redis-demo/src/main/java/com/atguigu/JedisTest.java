package com.atguigu;

import redis.clients.jedis.Jedis;

/**
 * @Author Ding Han
 * @Description
 * @create 2020-07-13 19:00
 * @Version 1.0
 */
public class JedisTest {
    public static void main(String[] args) {
        //1.创建Redis客户端
        Jedis jedis = new Jedis("hadoop102", 6379);

        //2.ping一下
        String ping = jedis.ping();

        //基本操作
        jedis.set("bbb", "2");

        //3.打印Ping
        System.out.println(ping);

        //4.关闭连接
        jedis.close();
    }
}
