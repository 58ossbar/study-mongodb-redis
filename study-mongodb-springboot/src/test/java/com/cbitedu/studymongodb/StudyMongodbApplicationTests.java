package com.cbitedu.studymongodb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cbitedu.studymongodb.entity.User;
import com.cbitedu.studymongodb.service.DeptService;
import com.cbitedu.studymongodb.service.UserService;
import com.mongodb.DBObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理的测试用例
 * 1.单个文档插入
 * 2.多个文档插入
 * 3.批量文档插入
 * 4、Json形式的文档插入
 */
@SpringBootTest
class StudyMongodbApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    DeptService deptService;

    @Test
    void contextLoads() {
    }

    /**
     * 测试mongodb新增文档
     */
    @Test
    public void TestUserInsertOne() {
        User user = new User();
        user.setName("信息学院");
        user.setAge(20);
        user.setSex("男");
        user.setMail("hniu@hniu.cn");
        user.setUsername("hniu");
        userService.save(user);
    }

    @Test
    public void TestUserInsertByTemplate() {
        User user = new User();
        user.setName("信息学院template");
        user.setAge(20);
        user.setSex("男");
        user.setMail("hniu@hniu.cn");
        user.setUsername("hniu_template");
        userService.saveByTemplate(user);
    }

    @Test
    public void TestUserInsertMany() {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setName("信息学院1");
        user1.setAge(20);
        user1.setSex("男");
        user1.setMail("hniu@hniu.cn1");
        user1.setUsername("hniu1");
        userList.add(user1);
        User user2 = new User();
        user2.setName("信息学院2");
        user2.setAge(20);
        user2.setSex("男");
        user2.setMail("hniu@hniu.cn1");
        user2.setUsername("hniu2");
        userList.add(user2);
        userService.save(userList);
    }

    @Test
    public void TestUserInsertyMan() {
        List<User> userList = new ArrayList<>();
        User user = null;
        for (int i = 0; i < 10000; i++) {
            user = new User();
            user.setName("信息学院n" + i);
            user.setAge(20 + i);
            user.setSex("男");
            user.setMail("hniu@hniu.cn" + i);
            user.setUsername("hniu" + i);
            userList.add(user);
        }
        userService.save(userList);
    }

    /**
     * json文件导入mongodb案例
     */
    @Test
    public void TestFileInsertMongodb() {
        Resource resource = new ClassPathResource("db/dept.json");
        String tempString = null;
        try {
            InputStream is = resource.getInputStream();
            // 获取字符缓冲流
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            String data=null;

            while ((data=br.readLine())!=null){
                DBObject bson = (DBObject)JSON.parse(data);
                userService.save((User) bson);
                System.out.println(JSON.toJSONString(data));
            }
            br.close();
            isr.close();
            is.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }
