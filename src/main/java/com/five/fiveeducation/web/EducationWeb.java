package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.Student;
import com.five.fiveeducation.service.EducationService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class EducationWeb {

    @Autowired
    private EducationService educationService;

    @PostMapping(value = "/save")
    public String save(Student student){
        return  educationService.save(student);
    }

    @GetMapping(value = "/findAll")
    public Page<Student> findAll(Pageable pageable){
        return educationService.findAll(pageable);
    }

    @PostMapping(value = "/findSearch")
    public Page<Student> findSearch(@QuerydslPredicate(root = Student.class) Predicate predicate,Pageable pageable){
        return educationService.findSearch(predicate,pageable);
    }

    @PostMapping(value = "/findHost")
    public Page<Student> findHost(@PageableDefault(sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable){
        return educationService.findHost(pageable);
    }

}
