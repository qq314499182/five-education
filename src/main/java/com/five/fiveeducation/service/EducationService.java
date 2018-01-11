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

    /**
     * 保存
     * @param student
     * @return
     */
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

    /**
     * 分页查询所有
     * @param pageable
     * @return
     */
    public Page<Student> findAll(Pageable pageable) {
        return educationDao.findAll(pageable);
    }

    /**
     * 带查询条件的分页查询
     * @param predicate 封装参数
     * @param pageable 分页参数
     * @return
     */
    public Page<Student> findSearch(Predicate predicate, Pageable pageable) {
        return educationDao.findAll(predicate,pageable);
    }

    /**
     * 热门查询
     * @param pageable
     * @return
     */
    public Page<Student> findHost(Pageable pageable) {
        return educationDao.findAll(pageable);
    }

    /**
     * 热门更新
     * @param student
     * @return
     */
    public String updateHost(Student student) {
        Student result = educationDao.getOne(student.getId());
        result.setHost((result.getHost()+1));
        try {
            result = educationDao.save(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null){
            return "ERROR";
        }else {
            return "OK";
        }
    }
}
