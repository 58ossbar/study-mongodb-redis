jedis连接池： JedisPool
        * 使用：
            1. 创建JedisPool连接池对象
            2. 调用方法 getResource()方法获取Jedis连接
                //0.创建一个配置对象
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxTotal(50);
                config.setMaxIdle(10);
        
                //1.创建Jedis连接池对象
                JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        
                //2.获取连接
                Jedis jedis = jedisPool.getResource();
                //3. 使用
                jedis.set("ossbar","欢迎来到开源吧");
        
        
                //4. 关闭 归还到连接池中
                jedis.close();
        