package com.ossbar.redis;

import com.ossbar.redis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

public class TestSsetsOperate {
    static Jedis jedis = JedisPoolUtils.getJedis();
    @Test
    public void zaddTest() {
        Map<String,Double> map = new HashMap<>();
        map.put("jack",5.0);
        map.put("bob",3.5);
        map.put("tom",6.0);
        Long result = jedis.zadd("score", map);
        System.out.println(result);
    }
    @Test
    public void zrangeTest() {
        Set<String> score = (Set<String>) jedis.zrange("score", 0, -1);
        Iterator<String> iterator = score.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
    @Test
    public void zcardTest () {
        Long num = jedis.zcard("score");
        System.out.println(num);
    }
    @Test
    public void zcountTest() {
        Long num = jedis.zcount("score", 2.0, 4.0);
        System.out.println(num);
    }
    @Test
    public void zscoreTest() {
        Double zscore = jedis.zscore("score", "jack");
        System.out.println(zscore);
    }
    @Test
    public void zremTest() {
        Long result = jedis.zrem("score", "tom");
        System.out.println(result);
    }




}
