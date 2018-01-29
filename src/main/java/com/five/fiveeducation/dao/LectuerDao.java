package com.five.fiveeducation.dao;

import com.five.fiveeducation.entity.Lectuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface LectuerDao extends JpaRepository<Lectuer,Long>,QueryDslPredicateExecutor<Lectuer> {

    List<Lectuer> findByMsg(String msg);
}
