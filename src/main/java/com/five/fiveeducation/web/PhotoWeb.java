package com.five.fiveeducation.web;

import com.five.fiveeducation.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class PhotoWeb {

    @Autowired
    private PhotoService photoService;

    @GetMapping("upload")
    public String upload(MultipartFile file,HttpServletRequest request){
        String photeUrl = photoService.upload(file,request);


        return null;

    }




}
