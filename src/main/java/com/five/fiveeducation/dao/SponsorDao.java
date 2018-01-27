package com.five.fiveeducation.dao;

import com.five.fiveeducation.entity.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorDao extends JpaRepository<Sponsor,Long> {
}
