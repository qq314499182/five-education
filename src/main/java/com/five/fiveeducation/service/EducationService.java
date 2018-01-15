package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.EducationDao;
import com.five.fiveeducation.entity.Education;
import com.five.fiveeducation.entity.QEducation;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EducationService {

    @Autowired
    private EducationDao educationDao;

    /**
     * 保存
     *
     * @param education
     * @return
     */
    public String save(Education education) {
        if (education != null) {
            //判断价位区间
            Integer expenses = education.getExpenses();
            if (expenses < 1000) {
                education.setPriceInterval("1000以下");
            }
            if (expenses >= 1000 && expenses < 1500){
                education.setPriceInterval("1000-1500");
            }
            if (expenses > 1500 && expenses < 2500){

            }

        }
        Education result = null;
        try {
            result = educationDao.saveAndFlush(education);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null) {
            return "ERROR";
        } else {
            return "OK";
        }
    }




    /**
     * 分页查询所有
     *
     * @param pageable
     * @return
     */
    public Page<Education> findAll(Pageable pageable) {
        QEducation education = QEducation.education;
        Predicate predicate = education.startDate.after(new Date());
        return educationDao.findAll(predicate, pageable);
    }

    /**
     * 带查询条件的分页查询
     *
     * @param predicate 封装参数
     * @param pageable  分页参数
     * @return
     */
    public Page<Education> findSearch(Predicate predicate, Pageable pageable) {
        return educationDao.findAll(predicate, pageable);
    }

    /**
     * 热门查询
     *
     * @param pageable
     * @return
     */
    public Page<Education> findHost(Pageable pageable) {
        QEducation education = QEducation.education;
        Predicate predicate = education.startDate.after(new Date());
        return educationDao.findAll(predicate, pageable);
    }

    /**
     * 热门更新
     *
     * @param education
     * @return
     */
    public String updateHost(Education education) {
        Education result = educationDao.getOne(education.getId());
        result.setHost((result.getHost() + 1));
        result.setScanTime(result.getScanTime() + education.getScanTime());
        try {
            result = educationDao.save(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null) {
            return "ERROR";
        } else {
            return "OK";
        }
    }
}
