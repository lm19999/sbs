package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.InitiationUrl;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.common.util.Upload;
import com.systop.sbs.common.util.UploadImage;
import com.systop.sbs.service.InitiationUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/3 11:10
 **/
@RestController
@CrossOrigin
@RequestMapping("/initiationUrl")
public class InitiationUrlController {

    @Autowired
    InitiationUrlService initiationUrlService;

    @RequestMapping("/selectAllInitiationUrl")
    public SbsResult selectAllInitiationUrl(){
        return SbsResult.success(initiationUrlService.selectAllInitiationUrl());
    }

    @RequestMapping("/selectlInitiationUrlById")
    public SbsResult selectlInitiationUrlById(@RequestParam("initiationUrlId") Integer initiationUrlId){
        return SbsResult.success(initiationUrlService.selectInitiationUrlById(initiationUrlId));
    }

    @RequestMapping("/insertInitiationUrl")
    public SbsResult insertAllInitiationUrl(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request,
            @RequestParam("initiationUrlName") String initiationUrlName,
            @RequestParam("initiationUrlTitle") String initiationUrlTitle,
            @RequestParam("initiationUrlDescribe") String initiationUrlDescribe,
            @RequestParam("remark") String remark){
        Upload upload = new Upload();
        InitiationUrl initiationUrl = new InitiationUrl();
        initiationUrl.setInitiationUrl(upload.upload(multipartFile,request));
        initiationUrl.setInitiationUrlName(initiationUrlName);
        initiationUrl.setInitiationUrlTitle(initiationUrlTitle);
        initiationUrl.setInitiationUrlDescribe(initiationUrlDescribe);
        initiationUrl.setRemark(remark);
        return SbsResult.success(initiationUrlService.insertInitiationUrl(initiationUrl));
    }

    @RequestMapping("/deleteInitiationUrl")
    public SbsResult deleteInitiationUrl(@RequestParam("initiationUrlId") Integer initiationUrlId){
        return SbsResult.success(initiationUrlService.deleteInitiationUrl(initiationUrlId));
    }
}
