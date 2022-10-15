package com.cbitedu.studymongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("user")   // 表示操作的是your database下的User集合
public class User {
    @MongoId
    public String id;
    private String name;
    private Integer age;
    private String username;
    private String password;
    private String mail;
    private String sex;
}