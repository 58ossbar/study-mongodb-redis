package com.cbitedu.studymongodb.service;

import com.cbitedu.studymongodb.dao.UserDao;
import com.cbitedu.studymongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User findUserByUsername(String username){
        return userDao.findUserByUsername(username);
    }
}
