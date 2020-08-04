package com.systop.sbs.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/3 14:32
 **/
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @PostMapping
    public FileInfo upload(HttpServletRequest request, @RequestParam(value = "editormd-image-file", required = false) MultipartFile file) throws Exception {
        log.info("【FileController】 fileName={},fileOrginNmae={},fileSize={}", file.getName(), file.getOriginalFilename(), file.getSize());
        log.info(request.getContextPath());

        /*String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newFileName = new Date().getTime() + "." + suffix;*/

        String realPath = System.getProperty("user.dir") + "/src/main/resources/static/upload/";
        System.out.println(realPath);
        File dir = new File(realPath);
        if (!dir.isDirectory()) {//文件目录不存在，就创建一个
            dir.mkdirs();
        }
        String fileName = file.getOriginalFilename();
        File localFile = new File(dir, fileName);
        file.transferTo(localFile);
        log.info(localFile.getAbsolutePath());
        String filePath = request.getScheme() + "://"
            + request.getServerName() + ":"
            + request.getServerPort()
            + "/upload/" + fileName;
        return new FileInfo(1, "上传成功",filePath);
    }

    /*@GetMapping("/{id}")
    public void downLoad(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition", "attachment;filename=test.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        } catch (Exception e) {

        }
    }*/
}
