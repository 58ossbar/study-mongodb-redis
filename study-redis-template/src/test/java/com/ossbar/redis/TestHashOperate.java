package com.ossbar.redis;

import com.ossbar.redis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Hash操作
 */
public class TestHashOperate {
    static Jedis jedis = JedisPoolUtils.getJedis();

    @Test
    public void hmsetTest() {
        Map<String,String> map = new HashMap<>();
        map.put("content", "hello world");
        map.put("author", "hniu");
        String hash = jedis.hmset("article", map);
        System.out.println(hash);
    }
    @Test
    public void hgetallTest() {
        Map<String, String> map = jedis.hgetAll("article");
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> keyVal : set) {
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
