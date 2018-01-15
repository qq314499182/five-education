package com.five.fiveeducation.dao;

import com.five.fiveeducation.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


public interface EducationDao extends JpaRepository<Education,Long>,QueryDslPredicateExecutor<Education> {

}
