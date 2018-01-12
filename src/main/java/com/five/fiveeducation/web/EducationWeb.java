package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.Student;
import com.five.fiveeducation.service.EducationService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class EducationWeb {

    @Autowired
    private EducationService educationService;

    @PostMapping(value = "save")
    public String save(Student student){
        return  educationService.save(student);
    }

    @GetMapping(value = "findAll")
    public List<Student> findAll(Pageable pageable){
        return educationService.findAll(pageable).getContent();
    }

    @PostMapping(value = "findSearch")
    public List<Student> findSearch(@QuerydslPredicate(root = Student.class) Predicate predicate,Pageable pageable){
        return educationService.findSearch(predicate,pageable).getContent();
    }

    @PostMapping(value = "findHost")
    public List<Student> findHost(@PageableDefault(sort = {"host"},direction = Sort.Direction.DESC) Pageable pageable){
        return educationService.findHost(pageable).getContent();
    }

    @PostMapping(value = "updateHost")
    public String updateHost(Student student){
        return educationService.updateHost(student);

    }

}
