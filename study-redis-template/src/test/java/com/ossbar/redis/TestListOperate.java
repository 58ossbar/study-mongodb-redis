package com.ossbar.redis;

import com.ossbar.redis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import java.util.List;

public class TestListOperate {
    static Jedis jedis = JedisPoolUtils.getJedis();
    @Test
    public void rpushAndLpushTest(){
        //将5个元素推入列表color的右端
        Long rpush = jedis.rpush("color", "blue", "green", "purple", "red", "white");
        //将3个元素推入列表color的左端
        Long lpush = jedis.lpush("color", "black","pink");
        System.out.println(rpush+"-----"+lpush);
    }
    @Test
    public void lrangeTest (){
        List<String> values = jedis.lrange("color", 0, 6);
        for (String value : values) {
            System.out.println(value);
        }
    }
    @Test
    public void lindexTest (){
        String value = jedis.lindex("color", 5);
        System.out.println(value);
    }
    @Test
    public void lpopTest (){
        String value = jedis.lpop("color");
        System.out.println(value);
    }
    @Test
    public void llenTest (){
        Long len = jedis.llen("color");
        System.out.println(len);
    }
    @Test
    public void lremTest (){
        Long result = jedis.lrem("color", 1, "red");
        System.out.println(result);
    }



}
