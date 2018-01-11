package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.EducationDao;
import com.five.fiveeducation.entity.Student;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EducationService {

    @Autowired
    private EducationDao educationDao;

    public String save(Student student) {
        Student result = null;
        try {
             result = educationDao.saveAndFlush(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null){
            return "ERROR";
        }else {
            return "OK";
        }
    }

    public Page<Student> findAll(Pageable pageable) {
        return educationDao.findAll(pageable);
    }

    public Page<Student> findSearch(Predicate predicate, Pageable pageable) {
        return educationDao.findAll(predicate,pageable);
    }

    public Page<Student> findHost(Pageable pageable) {
        return educationDao.findAll(pageable);
    }
}
