package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.TrainSubjectDao;
import com.five.fiveeducation.entity.TrainSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrainSubjectService {

    @Autowired
    private TrainSubjectDao trainSubjectDao;

    public List<TrainSubject> findAll() {
        return trainSubjectDao.findAll();
    }

    public Map<String,String> save(TrainSubject trainSubject) {
        Map<String,String> map = new HashMap<>();
        try {
            TrainSubject save = trainSubjectDao.save(trainSubject);
            if (save == null){
                map.put("state","500");
                map.put("message","保存失败,数据库返回结果null");
                return map;
            }
        } catch (Exception e) {
            map.put("state","500");
            map.put("message",e.getMessage());
            return map;
        }
        map.put("state","200");
        map.put("message","数据保存成功");
        return map;
    }

    public Map<String,String> update(TrainSubject trainSubject) {
        Map<String,String> map = new HashMap<>();
        try {
            TrainSubject save = trainSubjectDao.save(trainSubject);
            if (save == null){
                map.put("state","500");
                map.put("message","更新失败,数据库返回结果null");
                return map;
            }
        } catch (Exception e) {
            map.put("state","500");
            map.put("message",e.getMessage());
            return map;
        }
        map.put("state","200");
        map.put("message","数据更新成功");
        return map;
    }

    public Map<String,String> delete(TrainSubject trainSubject) {
        Map<String,String> map = new HashMap<>();
        try {
            trainSubjectDao.delete(trainSubject);
        } catch (Exception e) {
            map.put("state","500");
            map.put("message",e.getMessage());
            return map;
        }
        map.put("state","200");
        map.put("message","数据删除成功");
        return map;
    }
}
