package com.five.fiveeducation.dao;

import com.five.fiveeducation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


public interface EducationDao extends JpaRepository<Student,Long>,QueryDslPredicateExecutor<Student> {
}
