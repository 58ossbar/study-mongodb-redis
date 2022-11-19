package com.ossbar.redis;

import com.ossbar.redis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestStringOperate {
    //2.获取连接
   static Jedis jedis = JedisPoolUtils.getJedis();
    @Test
    public void setTest() {
        String oldValue = jedis.set("brand1", "ossbar");
        System.out.println(oldValue);
    }

    @Test
    public void getTest() {
        String oldValue = jedis.getSet("brand1", "ossbar");
        System.out.println(oldValue);
    }
    @Test
    public void strlenTest() {
        Long valueLen = jedis.strlen("brand6");
        System.out.println(valueLen);
    }
    @Test
    public void getrangeTest() {
        String value = jedis.getrange("brand6", 4, 7);
        System.out.println(value);
    }
    @Test
    public void appendTest() {
        Long len = jedis.append("brand1", "heima");
        System.out.println(len);
    }



}
