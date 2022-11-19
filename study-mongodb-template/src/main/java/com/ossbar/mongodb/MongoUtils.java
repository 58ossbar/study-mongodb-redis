package com.ossbar.mongodb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoUtils {
	private static Properties properties;
	private static MongoDatabase mongoDatabase;
	private static InputStream stream = null;
	private static String host;
	private static int port;
	private static String dbname;
	// 1.创建一个静态代码块，用于初始化工具类中的静态变量，该静态代码块在类加载过程中的初始化阶段 执行，并且只执行一次
	static {
		// 判断properties集合对象是否为空，为空则创建一个集合对象
		if (properties == null) {
			properties = new Properties();
		}
		/*
		 * 由于我们调用load方法，而load方法底层抛出了一个IOException异常，此异常为编译时期异常
		 * 所以，我们调用load方法时，需要处理底层抛过来的异常
		 */
		try {
			// 创建一个InputStream字节输入流对象，用于接收mongodb.properties配置文件中的配置参数
			stream = MongoUtils.class.getClassLoader().getResourceAsStream("mongodb.properties");
			// properties集合对象调用load()方法，将配置参数加载到properties集合中
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 根据mongodb.properties配置文件中的key，获取value值
		host = properties.getProperty("host");
		port = Integer.parseInt(properties.getProperty("port"));
		dbname = properties.getProperty("dbname");
	}

	// 2.定义一个getMongoClient()方法，用于获取MongoDB数据库的连接对象
	public static MongoClient getMongoClient() {
		// 由于MongoClients对象调用create()方法，该方法的参数是一个字符串，因此这里将host和port拼接成字符串，再作为参数传入到该方法中
		String addr = "mongodb://" + host + ":" + port;
		MongoClient mongoClient = MongoClients.create(addr);
		return mongoClient;
	}

	// 3.定义一个getMongoConn()方法，用于实现连接指定的MongoDB数据库
	public static MongoDatabase getMongoConn() {
		MongoClient mongoClient = getMongoClient();
		mongoDatabase = mongoClient.getDatabase(dbname);
		return mongoDatabase;
	}

	// 4.关闭连接
	public static void CloseMongoConn(MongoClient mongoClient) {
		mongoClient.close();
	}

}
