package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.User;
import com.five.fiveeducation.service.UserService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class UserWeb {

    @Autowired
    private UserService userService;

    /**
     * 新增用户方法
     * @param user 用户
     * @return Map<String,String>
     */
    @PostMapping("user-save")
    public Map<String,String> save(User user){
        return userService.save(user);
    }

    /**
     * 修改用户密码
     * @param user 用户
     * @return Map<String,String>
     */
    @PostMapping("user-update")
    public Map<String,String> update(User user){
        return userService.update(user);
    }

    @PostMapping("user-login")
    public Map<String,String> login(@QuerydslPredicate(root = User.class)Predicate predicate){
        return userService.login(predicate);
    }
}
