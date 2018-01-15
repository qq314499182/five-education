package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.EducationDao;
import com.five.fiveeducation.entity.Education;
import com.five.fiveeducation.entity.QEducation;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
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
        //根据费用判断价格区间
        Education  result = updatePriceInterval(education);
        try {
            result = educationDao.saveAndFlush(result);
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
        Predicate predicate = education.startDate.after(new Date()).and(education.isShow.eq(0));
        return educationDao.findAll(predicate, pageable);
    }

    /**
     * 带查询条件的分页查询
     * @param predicate
     * @param pageable
     * @return
     */
    public Page<Education> findSearchOne(Predicate predicate, Pageable pageable) {
        return educationDao.findAll(predicate, pageable);
    }

    /**
     * 热门查询
     *
     * @param pageable
     * @return
     */
    public Page<Education> findHost(Pageable pageable) {
        QEducation Qeducation = QEducation.education;
        Predicate predicate = Qeducation.startDate.after(new Date());
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


    private Education updatePriceInterval(Education education){
        if (education != null) {
            //判断价位区间
            Integer expenses = education.getExpenses();
            if (expenses != null){
                if (expenses < 1000) {
                    education.setPriceInterval("1000以下");
                }
                if (expenses >= 1000 && expenses < 1500){
                    education.setPriceInterval("1000-1500");
                }
                if (expenses >= 1500 && expenses < 2500){
                    education.setPriceInterval("1500-2500");
                }
                if (expenses >= 2500 && expenses < 3500){
                    education.setPriceInterval("2500-3500");
                }
                if (expenses >= 3500 ){
                    education.setPriceInterval("3500以上");
                }
            }
        }
        return education;
    }

    /**
     * 拼接查询条件（单选模式）
     * @param education
     * @return Predicate
     */
    private Predicate creatPredicate(Education education){
        QEducation Qeducation = QEducation.education;
        BooleanExpression expression = Qeducation.startDate.after(new Date()).and(Qeducation.isShow.eq(0));
        expression =  expression.and(Qeducation.country.eq(1));
        return expression;
    }
}
