package com.five.fiveeducation.dao;

import com.five.fiveeducation.entity.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface SponsorDao extends JpaRepository<Sponsor,Long>,QueryDslPredicateExecutor<Sponsor> {

    List<Sponsor> findByMsg(String msg);
}
