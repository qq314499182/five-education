package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.SponsorDao;
import com.five.fiveeducation.entity.Sponsor;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SponsorService {

    @Autowired
    private SponsorDao sponsorDao;

    private static Map<String,String> map = new HashMap<>();

    public List<Sponsor> findAll(Predicate predicate) {
        return(List<Sponsor>) sponsorDao.findAll(predicate);
    }

    public Map<String,String> save(Sponsor sponsor) {
        try {
            Sponsor save = sponsorDao.saveAndFlush(sponsor);
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

    public Map<String,String> update(Sponsor sponsor) {
        Map<String,String> map = new HashMap<>();
        try {
            Sponsor save = sponsorDao.saveAndFlush(sponsor);
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

    public Map<String,String> delete(Sponsor sponsor) {
        Map<String,String> map = new HashMap<>();
        try {
            sponsorDao.delete(sponsor);
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
