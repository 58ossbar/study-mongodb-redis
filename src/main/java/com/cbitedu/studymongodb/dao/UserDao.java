package com.cbitedu.studymongodb.dao;

import com.cbitedu.studymongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, String> {
    /**
     * 根据用户名查询对象
     * @param username
     * @return
     */
    public User findUserByUsername(String username);

}
