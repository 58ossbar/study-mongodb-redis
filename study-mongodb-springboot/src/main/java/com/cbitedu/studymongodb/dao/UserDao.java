package com.cbitedu.studymongodb.dao;

import com.cbitedu.studymongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 继承的MongoRepository接口
 * 泛型1是对应的domain包中的实体类
 * 泛型2是该类的对应的文档主键：如果是ObjectId类型的话，就要转换一下
 *
 */
public interface UserDao extends MongoRepository<User, String> {
    /**
     * 根据用户名查询对象
     * @param username
     * @return
     */
    public User findUserByUsername(String username);

}
