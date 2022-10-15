package com.cbitedu.studymongodb.dao;

import com.cbitedu.studymongodb.entity.Emp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpDao extends MongoRepository<Emp,String> {
}
