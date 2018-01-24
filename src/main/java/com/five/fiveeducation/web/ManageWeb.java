package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.Manage;
import com.five.fiveeducation.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ManageWeb {

    @Autowired
    private ManageService manageService;

    @GetMapping("manage-findAll")
    public Manage findAll(){
        return manageService.findAll();
    }

    @PostMapping("manage-update")
    public Map<String,String> update(Manage manage){
        return manageService.update(manage);
    }
}
