package com.five.fiveeducation.quartz;


import com.five.fiveeducation.dao.EducationDao;
import com.five.fiveeducation.entity.Education;
import com.five.fiveeducation.entity.QEducation;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Configurable
@EnableScheduling
public class EducationQuartz {

    @Autowired
    private EducationDao educationDao;

    @Scheduled(cron = "0 10 2 * * ? ")
    public void work()  {
        QEducation Qeducation = QEducation.education;
        Predicate predicate = Qeducation.startDate.before(new Date());
        Iterable<Education> educations = educationDao.findAll(predicate);
        if (educations != null){
            for (Education education : educations) {
                education.setOverdue(1);
            }
            educationDao.save(educations);
            System.out.println("定时任务执行，数据状态改变");
        }
    }
}
