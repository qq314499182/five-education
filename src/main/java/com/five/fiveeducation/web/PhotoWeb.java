package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.Photo;
import com.five.fiveeducation.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController()
public class PhotoWeb {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/photo-upload")
    public Map<String, String> upload(HttpServletRequest request){
        return photoService.upload(request);
    }

    @GetMapping("/photo-findAll")
    public List<Photo> findAll(){
        return photoService.findAll();
    }

    @PostMapping("/photo-delete")
    public Map<String, String> delete(Photo photo){
        return photoService.delete(photo);
    }

    @PostMapping("/photo-update")
    public Map<String,String> update(Photo photo){
        return photoService.update(photo);
    }

}
