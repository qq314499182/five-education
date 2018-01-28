package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.Lectuer;
import com.five.fiveeducation.service.LectuerService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class LectuerWeb {

    @Autowired
    private LectuerService lectuerService;

    @GetMapping("lectuer-findAll")
    public List<Lectuer> findAll(@QuerydslPredicate(root = Lectuer.class)Predicate predicate){
        return lectuerService.findAll(predicate);
    }

    @PostMapping("lectuer-save")
    public Map<String,String> save(Lectuer lectuer){
        return lectuerService.save(lectuer);
    }


    @PostMapping("lectuer-update")
    public Map<String,String> update(Lectuer lectuer){
        return lectuerService.update(lectuer);
    }


    @PostMapping("lectuer-delete")
    public Map<String,String> delete(Lectuer lectuer){
        return lectuerService.delete(lectuer);
    }
}
