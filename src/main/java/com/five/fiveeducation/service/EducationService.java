package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.EducationDao;
import com.five.fiveeducation.entity.Education;
import com.five.fiveeducation.entity.EducationSearch;
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
import java.util.List;
import java.util.Map;

@Service
public class EducationService {

    @Autowired
    private EducationDao educationDao;

    @Autowired
    private ManageService manageService;

    private static Map<String, String> map = new HashMap<>();

    /**
     * 保存
     *
     * @param education
     * @return Map<String, String>
     */
    public Map<String, String> save(Education education) {
        //根据费用更新价格区间
        Education result = updatePriceInterval(education);
        //根据持续时间更新持续时间区间
        result = updateDaysInterval(result);
        try {
            result = educationDao.saveAndFlush(result);
        } catch (Exception e) {
            map.put("state", "500");
            map.put("message", e.getMessage());
            return map;
        }
        if (result == null) {
            map.put("state", "500");
            map.put("message", "数据库返回结果为空");
            return map;
        } else {
            map.put("state", "200");
            map.put("message", "数据保存成功");
            return map;
        }
    }

    /**
     * 分页查询所有
     *
     * @param pageable
     * @return Page<Education>
     */
    public Page<Education> findAll(Predicate predicate, Pageable pageable) {
        return educationDao.findAll(predicate, pageable);
    }

    /**
     * 带查询条件的分页查询
     *
     * @param education
     * @param pageable
     * @return Page<Education>
     */
    public Page<Education> findSearch(EducationSearch education, Pageable pageable) {
        //拼接查询条件
        Predicate predicate = creatPredicate(education);
        Page<Education> all = educationDao.findAll(predicate, pageable);
        //统计累计搜索数
        manageService.updateSearchCount();
        return all;
    }

    /**
     * 热门查询
     *
     * @param pageable
     * @return Page<Education>
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
     * @return String
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

    /**
     * 更新价格区间
     *
     * @param education
     * @return Education
     */
    private Education updatePriceInterval(Education education) {
        if (education != null) {
            Integer expenses = education.getExpenses();
            if (expenses != null) {
                if (expenses < 1000) {
                    education.setPriceInterval("1000以下");
                }
                if (expenses >= 1000 && expenses < 1500) {
                    education.setPriceInterval("1000-1500");
                }
                if (expenses >= 1500 && expenses < 2500) {
                    education.setPriceInterval("1500-2500");
                }
                if (expenses >= 2500 && expenses < 3500) {
                    education.setPriceInterval("2500-3500");
                }
                if (expenses >= 3500) {
                    education.setPriceInterval("3500以上");
                }
            }
        }
        return education;
    }

    /**
     * 更新持续时间区间
     *
     * @param education
     * @return Education
     */
    private Education updateDaysInterval(Education education) {
        if (education != null) {
            if (education.getDays() < 1) {
                education.setDaysInterval("半天");
            }
            if (education.getDays() == 1) {
                education.setDaysInterval("1天");
            }
            if (education.getDays() == 2) {
                education.setDaysInterval("2天");
            }
            if (education.getDays() >= 3) {
                education.setDaysInterval("3天及以上");
            }
        }
        return education;
    }

    /**
     * 拼接查询条件
     *
     * @param education
     * @return Predicate
     */
    private Predicate creatPredicate(EducationSearch education) {
        QEducation Qeducation = QEducation.education;
        BooleanExpression expression = Qeducation.isShow.eq(0);
        expression = expression.and(Qeducation.overdue.eq(0));
        //培训类型
        if (education.getTrainType() != null) {
            expression = expression.and(Qeducation.trainType.in(education.getTrainType()));
        }
        //培训类型模糊查询
        if (education.getTrainTypeLike() != null) {
            expression = expression.and(Qeducation.trainType.like("%" + education.getTrainTypeLike() + "%"));
        }
        //培训主题
        if (education.getTrainSubject() != null) {
            expression = expression.and(Qeducation.trainSubject.in(education.getTrainSubject()));
        }
        //国家
        if (education.getCountry() != null) {
            expression = expression.and(Qeducation.country.in(education.getCountry()));
        }
        //地区
        if (education.getRegion() != null) {
            expression = expression.and(Qeducation.region.in(education.getRegion()));
        }
        //开始日期距今
        Integer stratDateSearch = education.getStratDateSearch();
        Date date = new Date();
        if (stratDateSearch != null) {
            // 15天以内
            if (stratDateSearch == 1) {
                Date date15 = DateUtils.getDateFromSourceDate(new Date(), 15);
                expression = expression.and(Qeducation.startDate.between(new Date(), date15));
            }
            //30天以内
            if (stratDateSearch == 2) {
                Date date30 = DateUtils.getDateFromSourceDate(date, 30);
                expression = expression.and(Qeducation.startDate.between(date, date30));
            }
            //60天以内
            if (stratDateSearch == 3) {
                Date date45 = DateUtils.getDateFromSourceDate(new Date(), 60);
                expression = expression.and(Qeducation.startDate.between(date, date45));
            }
            //90天以内
            if (stratDateSearch == 4) {
                Date date90 = DateUtils.getDateFromSourceDate(new Date(), 90);
                expression = expression.and(Qeducation.startDate.between(date, date90));
            }
            //180天以内
            if (stratDateSearch == 5) {
                Date date180 = DateUtils.getDateFromSourceDate(new Date(), 180);
                expression = expression.and(Qeducation.startDate.between(date, date180));
            }
            //全年
            if (stratDateSearch == 6) {
                Date date180 = DateUtils.getDateFromSourceDate(new Date(), 180);
                expression = expression.and(Qeducation.startDate.after(date180));
            }
        }
        //持续时间
        List<String> daysInterval = education.getDaysInterval();
        if (daysInterval != null) {
            expression.and(Qeducation.daysInterval.in(daysInterval));
        }
        //是否免费
        Integer isFree = education.getIsFree();
        if (isFree != null) {
            expression.and(Qeducation.isFree.eq(isFree));
        }
        //价格区间
        List<String> priceInterval = education.getPriceInterval();
        if (priceInterval != null) {
            expression.and(Qeducation.priceInterval.in(priceInterval));
        }
        //主办方
        List<String> sponsor = education.getSponsor();
        if (sponsor != null) {
            expression.and(Qeducation.sponsor.in(sponsor));
        }
        //讲师信息
        List<String> lectuer = education.getLectuer();
        if (lectuer != null) {
            expression.and(Qeducation.lectuer.in(lectuer));
        }

        return expression;
    }

    /**
     * 更新报名数
     * @param education
     * @return Map<String, String>
     */
    public Map<String, String> updateEnrollCount(Education education) {
        Education one = educationDao.findOne(education.getId());
        if (one != null) {
            one.setEnrollCount(one.getEnrollCount() + 1);
            try {
                Education save = educationDao.save(one);
                if (save == null){
                    map.put("state","500");
                    map.put("message","保存失败,数据库返回结果null");
                    return map;
                }
            } catch (Exception e) {
                map.put("state","500");
                map.put("message",e.getMessage());
                return map;
            }
            map.put("state","200");
            map.put("message","数据更新成功");
            return map;
        }else {
            map.put("state","500");
            map.put("message","数据库中没有这条记录");
            return map;
        }
    }

    /**
     * 更新点击外部连接数
     * @param education
     * @return Map<String,String>
     */
    public Map<String,String> updateClickCount(Education education) {
        Education one = educationDao.findOne(education.getId());
        if (one != null) {
            one.setClickCount(one.getClickCount() + 1);
            try {
                Education save = educationDao.save(one);
                if (save == null){
                    map.put("state","500");
                    map.put("message","保存失败,数据库返回结果null");
                    return map;
                }
            } catch (Exception e) {
                map.put("state","500");
                map.put("message",e.getMessage());
                return map;
            }
            map.put("state","200");
            map.put("message","数据更新成功");
            return map;
        }else {
            map.put("state","500");
            map.put("message","数据库中没有这条记录");
            return map;
        }
    }

    public Long findCount() {
        return educationDao.count();
    }
}
