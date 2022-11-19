package com.ossbar.redis;

import com.ossbar.redis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class TestSetOperate {
    static Jedis jedis = JedisPoolUtils.getJedis();

    public static void main(String[] args) {
        System.out.println("服务启动..." + jedis.ping());
    }

    @Test
    public void saddTest() {
        Long result = jedis.sadd("databases", "redis", "mongodb", "hbase");
        System.out.println(result);
    }

    @Test
    public void scardTest() {
        Long num = jedis.scard("databases");
        System.out.println(num);
    }
    @Test
    public void smembersTest () {
        Set<String> databases = jedis.smembers("databases");
        Iterator<String> database = databases.iterator();
        while (database.hasNext()){
            String db = database.next();
            System.out.println(db);
        }
    }
    @Test
    public void sismemberTest () {
        Boolean result = jedis.sismember("databases", "redis");
        System.out.println(result);
    }
    @Test
    public void sremTest () {
        Long result = jedis.srem("databases", "hbase");
        System.out.println(result);
    }

}
