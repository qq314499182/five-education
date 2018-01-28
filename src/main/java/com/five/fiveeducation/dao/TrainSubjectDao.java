package com.five.fiveeducation.dao;

import com.five.fiveeducation.entity.TrainSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface TrainSubjectDao extends JpaRepository<TrainSubject,Long>,QueryDslPredicateExecutor<TrainSubject> {
}
