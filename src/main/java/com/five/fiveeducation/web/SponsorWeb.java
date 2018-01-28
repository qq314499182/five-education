package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.Sponsor;
import com.five.fiveeducation.service.SponsorService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class SponsorWeb {

    @Autowired
    private SponsorService sponsorService;

    @GetMapping("sponsor-findAll")
    public List<Sponsor> findAll(@QuerydslPredicate(root = Sponsor.class)Predicate predicate){
        return sponsorService.findAll(predicate);
    }

    @PostMapping("sponsor-save")
    public Map<String,String> save(Sponsor sponsor){
        return sponsorService.save(sponsor);
    }


    @PostMapping("sponsor-update")
    public Map<String,String> update(Sponsor sponsor){
        return sponsorService.update(sponsor);
    }


    @PostMapping("sponsor-delete")
    public Map<String,String> delete(Sponsor sponsor){
        return sponsorService.delete(sponsor);
    }
}
