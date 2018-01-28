package com.five.fiveeducation.dao;

import com.five.fiveeducation.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


public interface EducationDao extends JpaRepository<Education,Long>,QueryDslPredicateExecutor<Education> {

    @Query(value = "SELECT  SUM(e.enroll_count ) FROM education e",nativeQuery = true)
    Long countByEnrollCount();
    @Query(value = "SELECT  SUM(e.click_count) FROM education e",nativeQuery = true)
    Long countByClickCount();
}
