package com.five.fiveeducation.dao;

import com.five.fiveeducation.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhotoDao extends JpaRepository<Photo,Long> {

}
