package com.cbitedu.studymongodb.dao;

import com.cbitedu.studymongodb.entity.Dept;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeptDao extends MongoRepository<Dept,String > {
}
