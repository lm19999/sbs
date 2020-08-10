package com.systop.sbs.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/9 17:39
 **/
public class UploadMore {

    public static String uploadFile(MultipartFile file) {
        String realPath = System.getProperty("user.dir") + "/src/main/resources/static/upload/";
        System.out.println(realPath);
        File dir = new File(realPath);
        if (!dir.isDirectory()) {//文件目录不存在，就创建一个
            dir.mkdirs();
        }

        try {
            String filename = file.getOriginalFilename();
            //服务端保存的文件对象
            File fileServer = new File(dir, filename);
            System.out.println("file文件真实路径:" + fileServer.getAbsolutePath());
            //2，实现上传
            file.transferTo(fileServer);
            String filePath = "http://localhost:8080" + ":"
                    + "/upload/" + filename;
            //3，返回可供访问的网络路径
            return filePath;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    public static String uploadImages(MultipartFile[] files) {
        String url = "";
        for (MultipartFile file : files) {
            String imageUrl = uploadFile(file);
            if (imageUrl!=null) {
                url += imageUrl + "&";
            }
        }
        return url;
    }
}
