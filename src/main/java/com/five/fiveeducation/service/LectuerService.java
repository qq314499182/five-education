package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.LectuerDao;
import com.five.fiveeducation.entity.Lectuer;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LectuerService {

    @Autowired
    private LectuerDao lectuerDao;

    public List<Lectuer> findAll(Predicate predicate) {
        return (List<Lectuer>) lectuerDao.findAll(predicate);
    }

    public Map<String,String> save(Lectuer lectuer) {
        Map<String,String> map = new HashMap<>();
        try {
            Lectuer save = lectuerDao.saveAndFlush(lectuer);
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

    public Map<String,String> update(Lectuer lectuer) {
        Map<String,String> map = new HashMap<>();
        try {
            Lectuer save = lectuerDao.saveAndFlush(lectuer);
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

    public Map<String,String> delete(Lectuer lectuer) {
        Map<String,String> map = new HashMap<>();
        try {
            lectuerDao.delete(lectuer);
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
