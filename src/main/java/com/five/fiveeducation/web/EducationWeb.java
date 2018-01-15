package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.Education;
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
import java.util.Map;

@RestController()
public class EducationWeb {

    @Autowired
    private EducationService educationService;

    @PostMapping(value = "save")
    public Map<String,String> save(Education education){
        return  educationService.save(education);
    }

    @GetMapping(value = "findAll")
    public List<Education> findAll(@QuerydslPredicate(root = Education.class) Predicate predicate, Pageable pageable){
        return educationService.findAll(predicate,pageable).getContent();
    }

    @PostMapping(value = "findSearchOne")
    public List<Education> findSearchOne(Education education, Pageable pageable){
        return educationService.findSearchOne(education,pageable).getContent();
    }

    @PostMapping(value = "findHost")
    public List<Education> findHost(@PageableDefault(sort = {"host","scanTime"},direction = Sort.Direction.DESC) Pageable pageable){
        return educationService.findHost(pageable).getContent();
    }

    @PostMapping(value = "updateHost")
    public String updateHost(Education education){
        return educationService.updateHost(education);

    }

}
