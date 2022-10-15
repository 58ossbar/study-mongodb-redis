package mongodb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;

import com.creatorblue.mongodb.MongoUtils;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;

/**
 * 
 * @author zhujw
 *
 */
public class TestMongo {
	private static MongoDatabase mongoDatabase;

	public static void main(String[] args) {
		mongoDatabase = MongoUtils.getMongoConn();
	}

	/*
	 * 获取MongoDB中的所有数据库
	 */
	@Test
	public void getDBs() {
		MongoClient mongoClient = MongoUtils.getMongoClient();
		MongoIterable<String> databaseNames = mongoClient.listDatabaseNames();
		for (String databaseName : databaseNames) {
			System.out.println(databaseName);
		}
		MongoUtils.CloseMongoConn(mongoClient);
	}

	/*
	 * 查看指定数据库（即数据库articledb）中的所有集合
	 */
	@Test
	public void getCollection() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoIterable<String> listCollectionNames = mongoDatabase.listCollectionNames();
		for (String collectionName : listCollectionNames) {
			System.out.println(collectionName.toString());
		}
	}

	/*
	 * 创建集合
	 */
	@Test
	public void createCollection() {
		mongoDatabase = MongoUtils.getMongoConn();

		mongoDatabase.createCollection("comment");
	}

	/*
	 * 删除集合
	 */
	@Test
	public void dropCollection() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoCollection<Document> creatorblue = mongoDatabase.getCollection("student");
		creatorblue.drop();

	}

	/*
	 * 查看文档
	 */
	@Test
	public void findDocument() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoCollection<Document> comment = mongoDatabase.getCollection("emp");
		FindIterable<Document> documents = comment.find();
		for (Document document : documents) {
			System.out.println(document);
		}
		
	}

	/*
	 * 插入一个文档
	 */
	@Test
	public void insertOneDocument() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoCollection<Document> comment = mongoDatabase.getCollection("comment");
		Document document = new Document("_id", "7").append("articleid", "100001")
				.append("content", "吃饭前，先喝杯水或一碗汤，可减少饭量，对控制体重有帮助").append("userid", "1007").append("nickname", "玛丽莲•梦露")
				.append("age", "18").append("phone", " 13937165554").append("createdatetime", new Date())
				.append("likenum", "8888").append("state", "null");
		comment.insertOne(document);
	}

	/*
	 * 更新文档
	 */
	@Test
	public void updateDocument() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoCollection<Document> comment = mongoDatabase.getCollection("comment");
		Document document = new Document("content", "饭后半小时最好不要喝大量的水，以免冲淡胃液，稀释胃酸，损害消化功能");
		comment.updateOne(Filters.eq("content", "吃饭前，先喝杯水或一碗汤，可减少饭量，对控制体重有明显的帮助"), new Document("$set", document));
	}

	/*
	 * 删除文档
	 */
	@Test
	public void deleteDocument() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoCollection<Document> comment = mongoDatabase.getCollection("comment");
		comment.deleteOne(Filters.eq("_id", "7"));
	}

	/**
	 * 查询工资小于2000的员工
	 */
	@Test
	public void findEmpByLt2000() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoCollection<Document> emp = mongoDatabase.getCollection("emp");
		BasicDBObject q = new BasicDBObject();
		q.put("sal",new BasicDBObject("$lt",2000));
		FindIterable<Document> documents = emp.find(q);
		//FindIterable<Document> documents =emp.find(new Document("sal",new Document("$lt",2000)));
		for (Document document : documents) {
			System.out.println(document.toJson());
		}

	}
	/**
	 * 查询工资1000-2000间的员工
	 */
	@Test
	public void findEmpByBetween1000And2000() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoCollection<Document> emp = mongoDatabase.getCollection("emp");
		FindIterable<Document> documents=emp.find(Filters.where("this.sal>=1000&&this.sal<=2000"));
		for (Document document : documents) {
			System.out.println(document.toJson());
		}
	}
	/**
	 * 查询工资不等于800的员工
	 */
	@Test
	public void findEmpBySalLt800() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoCollection<Document> emp = mongoDatabase.getCollection("emp");
		FindIterable<Document> documents=emp.find(Filters.ne("sal", 800));
		//FindIterable<Document> documents=emp.find(Filters.eq("sal", 800));
		for (Document document : documents) {
			System.out.println(document.toJson());
		}
}

	/**
	 * 查询工资小于1000或大于2500的员工
	 */
	@Test
	public void findEmpBySalOr() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoCollection<Document> emp = mongoDatabase.getCollection("emp");
		//FindIterable<Document> documents=emp.find(Filters.where("this.sal<1000||this.sal>2500"));
		//FindIterable<Document> documents=emp.find(Filters.eq("sal", 800));
		List list = new ArrayList();
		list.add(new Document("sal",800));
		list.add(new Document("sal",2000));
		FindIterable<Document> documents = emp.find(new Document("$or", list));
		for (Document document : documents) {
			System.out.println(document.toJson());
		}
	}

	/**
	 * 为所有薪资低于1000的员工增加工资400元
	 *
	 *
	 */
	@Test
	public void findEmpBySalInc() {
		mongoDatabase = MongoUtils.getMongoConn();
		MongoCollection<Document> emp = mongoDatabase.getCollection("emp");
		Bson filter=Filters.lt("sal",1000);
		Document document=new Document("$inc",new Document("sal",400));
		emp.updateMany(filter, document);
	}
}
