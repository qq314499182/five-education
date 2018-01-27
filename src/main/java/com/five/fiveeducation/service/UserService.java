package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.UserDao;
import com.five.fiveeducation.entity.User;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    private static Map<String,String> map = new HashMap<>();

    public Map<String,String> save(User user) {
        User result = null;
        try {
            result = userDao.saveAndFlush(user);
        } catch (Exception e) {
            map.put("state", "500");
            map.put("message", e.getMessage());
            return map;
        }
        if (result == null) {
            map.put("state", "500");
            map.put("message", "数据库返回结果为空");
            return map;
        } else {
            map.put("state", "200");
            map.put("message", "数据保存成功");
            return map;
        }
    }

    public Map<String,String> update(User user) {
        User result = null;
        try {
            result = userDao.saveAndFlush(user);
        } catch (Exception e) {
            map.put("state", "500");
            map.put("message", e.getMessage());
            return map;
        }
        if (result == null) {
            map.put("state", "500");
            map.put("message", "数据库返回结果为空");
            return map;
        } else {
            map.put("state", "200");
            map.put("message", "数据更新成功");
            return map;
        }
    }


    public Map<String,String> login(Predicate predicate) {
        List<User>list = null;
        try {
             list = (ArrayList)userDao.findAll(predicate);
        } catch (Exception e) {
            map.put("state", "500");
            map.put("message", e.getMessage());
            return map;
        }
        if (list == null && list.size() == 0){
            map.put("state", "500");
            map.put("message", "账号或密码错误");
            return map;
        }else {
            map.put("state", "200");
            map.put("message", "登陆成功");
            return map;
        }

    }
}
