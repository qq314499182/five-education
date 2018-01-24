package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.TrainSubject;
import com.five.fiveeducation.service.TrainSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TrainSubjectWeb {

    @Autowired
    private TrainSubjectService trainSubjectService;

    @GetMapping("train-subject-findAll")
    public List<TrainSubject> findAll(){
        return trainSubjectService.findAll();
    }

    @PostMapping("train-subject-save")
    public Map<String,String> save(TrainSubject trainSubject){
        return trainSubjectService.save(trainSubject);
    }


    @PostMapping("train-subject-update")
    public Map<String,String> update(TrainSubject trainSubject){
        return trainSubjectService.update(trainSubject);
    }


    @PostMapping("train-subject-delete")
    public Map<String,String> delete(TrainSubject trainSubject){
        return trainSubjectService.delete(trainSubject);
    }
}
