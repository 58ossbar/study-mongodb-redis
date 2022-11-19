package com.creatorblue.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

public class TestHashOperate {
    private static Jedis jedis = new Jedis("127.0.0.1", 6379);
    public static void main(String[] args) {
        System.out.println("服务启动..." + jedis.ping());
    }

    @Test
    public void hmsetTest() {
        Map<String,String> map = new HashMap<>();
        map.put("content", "hello world");
        map.put("author", "peter");
        String hash = jedis.hmset("article", map);
        System.out.println(hash);
    }
    @Test
    public void hgetallTest() {
        Map<String, String> map = jedis.hgetAll("article");
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> keyVal = iterator.next();
            System.out.println(keyVal);
        }

    }
    @Test
    public void hkeysTest() {
        Set<String> keys = jedis.hkeys("article");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key);
        }
    }

    @Test
    public void hvalsTest() {
        List<String> vals = jedis.hvals("article");
        for (String val : vals) {
            System.out.println(val);
        }
    }

    @Test
    public void hdelTest() {
        Long result = jedis.hdel("article", "author");
        System.out.println(result);

    }

}
