package com.creatorblue.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestKeyOperate {

    private static Jedis jedis = new Jedis("127.0.0.1", 6379);
    public static void main(String[] args) {
        System.out.println("服务启动..." + jedis.ping());
        jedis.flushDB();
    }


    /*
     *为指定键设置值
     * */
    @Test
    public void setTest() {
        String key = jedis.set("company", "itcast");
        System.out.println(key);
    }

    @Test
    public void msetTest() {
        String manyKey = jedis.mset("brand1", "heima", "brand2", "chuanzhihui", "brand3",
                "kudingyu","brand4","boxuegu","brand5","czzxxy","brand6","yuanxiaobang");
        System.out.println(manyKey);
    }

    @Test
    public void keysTest() {
        Set<String> keys = jedis.keys("*");
        Iterator<String> itKeys = keys.iterator();
        while (itKeys.hasNext()){
            String key = itKeys.next();
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
