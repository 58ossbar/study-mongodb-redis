package com.ossbar.redis;

import com.ossbar.redis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class TestKeyOperate {
    static Jedis jedis = JedisPoolUtils.getJedis();

    /*
     *为指定键设置值
     * */
    @Test
    public void setTest() {
        String key = jedis.set("company", "ossbar");
        System.out.println(key);
    }

    @Test
    public void msetTest() {
        String manyKey = jedis.mset("brand1", "宝马", "brand2", "奔驰", "brand3",
                "悍马","brand4","别克","brand5","特斯拉","brand6","林肯");
        System.out.println(manyKey);
    }

    @Test
    public void keysTest() {
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    @Test
    public void mgetTest() {
        List<String> values = jedis.mget("brand1", "brand3", "brand");
        for (String value : values) {
            System.out.println(value);
        }
    }

    @Test
    public void existTest() {
        Boolean result1 = jedis.exists("company");
        Boolean result2 = jedis.exists("brand0");
        System.out.println(result1+"------------"+result2);
    }

    @Test
    public void renameTest() {
        String rename = jedis.rename("company", "companyNew");
        System.out.println(rename);
    }

    @Test
    public void delTest() {
        Long result = jedis.del("companyNew");
        System.out.println(result);
    }



}
