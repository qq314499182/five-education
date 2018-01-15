package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.EducationDao;
import com.five.fiveeducation.entity.Education;
import com.five.fiveeducation.entity.QEducation;
import com.five.fiveeducation.utils.DateUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String,String> save(Education education) {
        Map<String,String> map = new HashMap<>();
        //根据费用判断价格区间
        Education  result = updatePriceInterval(education);
        try {
            result = educationDao.saveAndFlush(result);
        } catch (Exception e) {
            map.put("state","500");
            map.put("message",e.getMessage());
            return map;
        }
        if (result == null) {
            map.put("state","500");
            map.put("message","数据库返回结果为空");
            return map;
        } else {
            map.put("state","200");
            map.put("message","数据保存成功");
            return map;
        }
    }

    /**
     * 分页查询所有
     *
     * @param pageable
     * @return
     */
    public Page<Education> findAll(Predicate predicate,Pageable pageable) {
        return educationDao.findAll(predicate, pageable);
    }

    /**
     * 带查询条件的分页查询
     * @param education
     * @param pageable
     * @return
     */
    public Page<Education> findSearchOne(Education education, Pageable pageable) {
        //拼接查询条件
        Predicate predicate = creatPredicate(education);
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
        BooleanExpression expression = Qeducation.isShow.eq(0);
        expression =  expression.and(Qeducation.overdue.eq(0));
        //培训类型
        if (education.getTrainType() != null){
            expression = expression.and(Qeducation.trainType.eq(education.getTrainType()));
        }
        //培训主题
        if (education.getTrainSubject() != null){
            expression = expression.and(Qeducation.trainSubject.eq(education.getTrainSubject()));
        }
        //国家
        if (education.getCountry() != null){
            expression = expression.and(Qeducation.country.eq(education.getCountry()));
        }
        //地区
        if (education.getRegion() != null){
            expression = expression.and(Qeducation.region.eq(education.getRegion()));
        }
        //开始日期距今
        Integer stratDateSearch = education.getStratDateSearch();
        if (stratDateSearch != null){
            // 15天以内
            if (stratDateSearch == 1){
                Date date15 = DateUtils.getDateFromSourceDate(new Date(), 15);
                expression =  expression.and(Qeducation.startDate.between(new Date(),date15));
            }
            //15-30天
            if (stratDateSearch == 2){
                Date date15 = DateUtils.getDateFromSourceDate(new Date(), 15);
                Date date30 = DateUtils.getDateFromSourceDate(new Date(), 30);
                expression = expression.and(Qeducation.startDate.between(date15,date30));
            }
            //30-45天
            if (stratDateSearch == 3){
                Date date30 = DateUtils.getDateFromSourceDate(new Date(), 30);
                Date date45 = DateUtils.getDateFromSourceDate(new Date(), 45);
                expression = expression.and(Qeducation.startDate.between(date30,date45));
            }
            //45-90天
            if (stratDateSearch == 4){
                Date date45 = DateUtils.getDateFromSourceDate(new Date(), 45);
                Date date90 = DateUtils.getDateFromSourceDate(new Date(), 90);
                expression = expression.and(Qeducation.startDate.between(date45,date90));
            }
            //90-180天
            if (stratDateSearch == 5){
                Date date90 = DateUtils.getDateFromSourceDate(new Date(), 90);
                Date date180 = DateUtils.getDateFromSourceDate(new Date(), 180);
                expression = expression.and(Qeducation.startDate.between(date90,date180));
            }
            //全年
            if (stratDateSearch == 6){
                Date date180 = DateUtils.getDateFromSourceDate(new Date(), 180);
                expression = expression.and(Qeducation.startDate.after(date180));
            }
        }



        return expression;
    }
}
