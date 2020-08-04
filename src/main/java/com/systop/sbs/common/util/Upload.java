package com.systop.sbs.common.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/30 10:52
 **/
public class Upload {
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        /*
         定义文件的存储路径,如下，是在linux和mac上定义的文件路径
        /private/var/folders/8x/4zvnbqmj1w33cqmzrpygzbth0000gn/T/tomcat-docbase.5206733816001100271.8080/uploadFile
         */

        String realPath = System.getProperty("user.dir") + "/src/main/resources/static/upload/";
        System.out.println(realPath);
        File dir = new File(realPath);
        if (!dir.isDirectory()) {//文件目录不存在，就创建一个
            dir.mkdirs();
        }

        try {
            String filename = uploadFile.getOriginalFilename();
            //服务端保存的文件对象
            File fileServer = new File(dir, filename);
            System.out.println("file文件真实路径:" + fileServer.getAbsolutePath());
            //2，实现上传
            uploadFile.transferTo(fileServer);
            String filePath = request.getScheme() + "://" +
                    request.getServerName() + ":"
                    + request.getServerPort()
                    + "/upload/" + filename;
            //3，返回可供访问的网络路径
            return filePath;

//            暂时返回本地存储的绝对路径
//            部署之后返回项目的网络路径！！！！！
//            return fileServer.getAbsolutePath();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

}
