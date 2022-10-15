package com.cbitedu.studymongodb.service;

import com.cbitedu.studymongodb.dao.UserDao;
import com.cbitedu.studymongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    MongoTemplate mongoTemplate;
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 新增和修改
     *
     * @param user
     */
    public void save(User user) {
        userDao.save(user);
    }
    public void saveByTemplate(User user) {
        mongoTemplate.save(user,"user");
    }

    public void save(List list) {
        userDao.saveAll(list);
    }

    public void deleteById(String id) {
        userDao.deleteById(id);
    }
}
