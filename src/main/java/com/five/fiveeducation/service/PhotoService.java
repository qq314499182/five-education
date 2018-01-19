package com.five.fiveeducation.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class PhotoService {


    public String upload(MultipartFile file, HttpServletRequest request) {
        //获取项目绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("");
        //获取图片文件名称
        String fileName = file.getOriginalFilename() + System.currentTimeMillis();

        if (!file.isEmpty()) {
            try {
                Files.copy(file.getInputStream(), Paths.get(realPath + "/photo", fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;

    }
}
