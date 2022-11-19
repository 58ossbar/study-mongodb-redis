package com.ossbar.redis.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 连接池工具类
 * 
 * @author zhujw
 *
 */
public class JedisPoolUtils {

        private static JedisPool jedisPool;
    
        static{
            //读取配置文件
            InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
            //创建Properties对象
            Properties pro = new Properties();
            //关联文件
            try {
                pro.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取数据，设置到JedisPoolConfig中
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(Integer.parseInt(pro.getProperty("redis.maxTotal")));
            config.setMaxIdle(Integer.parseInt(pro.getProperty("redis.maxIdle")));
            //初始化JedisPool
            jedisPool = new JedisPool(config,pro.getProperty("redis.host"),Integer.parseInt(pro.getProperty("redis.port")),Integer.parseInt(pro.getProperty("redis.timeout")),pro.getProperty("redis.password"),Integer.parseInt(pro.getProperty("redis.database")));
    
    
    
        }
    
    
        /**
         * 获取连接方法
         */
        public static Jedis getJedis(){
            return jedisPool.getResource();
        }
    }
