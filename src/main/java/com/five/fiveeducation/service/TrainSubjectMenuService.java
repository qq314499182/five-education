package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.TrainSubjectDao;
import com.five.fiveeducation.entity.TrainSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainSubjectMenuService {

    @Autowired
    private TrainSubjectDao trainSubjectMeunDao;


    public List<TrainSubject> findAll() {
        return trainSubjectMeunDao.findAll();
    }
}
