package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.PhotoDao;
import com.five.fiveeducation.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhotoService {

    @Value("${photo.url}")
    private String photeUrl ;

    @Value("${photo.path}")
    private String photoPath;

    @Autowired
    private PhotoDao photoDao;

    private static Map<String, String> map = new HashMap<>();

    public Map<String, String> upload(HttpServletRequest request) {

        //存储文件
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;
        MultipartFile file = mRequest.getFile("file");
        //获取项目绝对路径
       // String realPath = request.getSession().getServletContext().getRealPath("upload/");
        //获取图片文件名称
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        photeUrl = photeUrl+fileName;
        if (!file.isEmpty()) {
            try {
                uploadFile(file.getBytes(),photoPath,fileName);
            } catch (IOException e) {
                map.put("state","500");
                map.put("message",e.getMessage());
                return map;
            }
        }

        //储存其他表单信息
        String url = mRequest.getParameter("url");
        String photoMessage = mRequest.getParameter("photoMessage");

        Photo photo = new Photo();
        photo.setPhotoUrl(photeUrl);
        photo.setUrl(url);
        photo.setPhotoMessage(photoMessage);


        Photo result = null;
        try {
            result = photoDao.save(photo);
        } catch (Exception e) {
            map.put("state","500");
            map.put("message",e.getMessage());
            return map;
        }
        if (result == null) {
            map.put("state","500");
            map.put("message","数据库返回结果为空");
            return map;
        } else {
            map.put("state", "200");
            map.put("message", "数据保存成功");
            return map;
        }
    }

    public  void uploadFile(byte[] file, String filePath, String fileName) throws IOException {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public List<Photo> findAll() {
        return photoDao.findAll();
    }

    public Map<String, String> delete(Photo photo) {
        try {
            photoDao.delete(photo);
        } catch (Exception e) {
            map.put("state","500");
            map.put("message",e.getMessage());
            return map;
        }
        map.put("state","200");
        map.put("message","数据删除成功");
        return map;
    }

    public Map<String,String> update(Photo photo) {
        HashMap<String, String> map = new HashMap<>();
        try {
             photo = photoDao.save(photo);
        } catch (Exception e) {
            map.put("state","500");
            map.put("message",e.getMessage());
            return map;
        }
        if (photo == null){
            map.put("state","500");
            map.put("message","数据库返回结果为空");
            return map;
        }else {
            map.put("state", "200");
            map.put("message", "数据更新成功");
            return map;
        }
    }
}
