package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.ManageDao;
import com.five.fiveeducation.entity.Manage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManageService {

    @Autowired
    private ManageDao manageDao;

    @Autowired
    private EducationService educationService;

    /**
     * 获取后台管理数据
     * @return List<Manage>
     */
    public Manage findAll() {
        List<Manage> list = manageDao.findAll();
        if (list != null && list.size() > 0){
            Manage manage = list.get(0);
            Long count = educationService.findCount();
            manage.setListCount(count);
            return manage;
        }
        return null;
    }

    /**
     * 更新后台管理数据
     * @param manage 管理实体
     * @return Map<String,String>
     */
    public Map<String,String> update(Manage manage) {
        Map<String,String> map = new HashMap<>();
        try {
            Manage save = manageDao.save(manage);
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
        map.put("message","数据更新成功");
        return map;
    }

    public void updateSearchCount() {
        List<Manage> list = manageDao.findAll();
        if (list != null && list.size() > 0){
            Manage manage = list.get(0);
            manage.setSearchCount(manage.getSearchCount()+1L);
            try {
                Manage save = manageDao.save(manage);
                if(save == null){
                    throw new RuntimeException("更新累计搜索,数据库返回结果null");
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

    }
}
