package com.ossbar.redis.utils;

import redis.clients.jedis.Jedis;

public class JedisPoolTest {
	public static void main(String[] args) {
		//1.创建Jedis连接池对象
	    //2.获取连接
	    Jedis jedis = JedisPoolUtils.getJedis();
	    //3. 使用
	    jedis.set("ossbar","欢迎来到开源吧");

	    //4. 关闭 归还到连接池中
	    jedis.close();
		}
	}
