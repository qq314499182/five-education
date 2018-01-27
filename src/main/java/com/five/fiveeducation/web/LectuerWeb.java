package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.Lectuer;
import com.five.fiveeducation.entity.TrainSubject;
import com.five.fiveeducation.service.LectuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LectuerWeb {

    @Autowired
    private LectuerService lectuerService;

    @GetMapping("train-subject-findAll")
    public List<Lectuer> findAll(){
        return lectuerService.findAll();
    }

    @PostMapping("train-subject-save")
    public Map<String,String> save(Lectuer lectuer){
        return lectuerService.save(lectuer);
    }


    @PostMapping("train-subject-update")
    public Map<String,String> update(Lectuer lectuer){
        return lectuerService.update(lectuer);
    }


    @PostMapping("train-subject-delete")
    public Map<String,String> delete(Lectuer lectuer){
        return lectuerService.delete(lectuer);
    }
}
