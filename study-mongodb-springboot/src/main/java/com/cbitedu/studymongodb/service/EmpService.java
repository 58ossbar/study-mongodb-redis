package com.cbitedu.studymongodb.service;

import com.cbitedu.studymongodb.dao.EmpDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmpService {
    EmpDao empDao;
}
