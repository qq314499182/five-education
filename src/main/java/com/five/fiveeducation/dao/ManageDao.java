package com.five.fiveeducation.dao;

import com.five.fiveeducation.entity.Manage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ManageDao extends JpaRepository<Manage,Long>,QueryDslPredicateExecutor<Manage> {
}
