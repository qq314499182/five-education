package com.five.fiveeducation.dao;

import com.five.fiveeducation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserDao extends JpaRepository<User,Long>,QueryDslPredicateExecutor<User> {
}
