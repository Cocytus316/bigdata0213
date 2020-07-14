package com.atguigu;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author Ding Han
 * @Description
 * @create 2020-07-13 19:08
 * @Version 1.0
 */
public class JedisPoolTest {
    public static void main(String[] args) {
        //1.创建Jedis连接池
        JedisPool jedisPool = new JedisPool("hadoop102", 6379);

        //2.从连接池中获取连接
        Jedis jedis = jedisPool.getResource();

        //3.测试连接
        System.out.println(jedis.ping());

        //4.归还连接
        jedis.close();
    }
}
