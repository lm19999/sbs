package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.Initiation;
import com.systop.sbs.common.pojo.InitiationUrl;
import com.systop.sbs.common.pojo.Lrc;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.common.util.Upload;
import com.systop.sbs.common.util.UploadImage;
import com.systop.sbs.service.InitiationService;
import com.systop.sbs.service.InitiationUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/3 11:10
 **/
@RestController
@CrossOrigin
@RequestMapping("/initiationUrl")
@Transactional
public class InitiationUrlController {

    @Autowired
    InitiationUrlService initiationUrlService;
    @Autowired
    InitiationService initiationService;

    @RequestMapping("/selectAllInitiationUrl")
    public SbsResult selectAllInitiationUrl(){
        return SbsResult.success(initiationUrlService.selectAllInitiationUrl());
    }

    @RequestMapping("/selectlInitiationUrlById")
    public SbsResult selectlInitiationUrlById(@RequestParam("initiationUrlId") Integer initiationUrlId){
        return SbsResult.success(initiationUrlService.selectInitiationUrlById(initiationUrlId));
    }

    @RequestMapping("/selectInitiationUrlByType")
    public SbsResult selectInitiationUrlByType(@RequestParam("initiationUrlType") Integer initiationUrlType){
        return SbsResult.success(initiationUrlService.selectInitiationUrlByType(initiationUrlType));
    }

    @RequestMapping("/insertInitiationUrl")
    public SbsResult insertAllInitiationUrl(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request,
            @RequestParam("initiationUrlType") Integer initiationUrlType,
            @RequestParam("initiationUrlName") String initiationUrlName,
            @RequestParam("initiationUrlTitle") String initiationUrlTitle,
            @RequestParam("initiationUrlDescribe") String initiationUrlDescribe,
            @RequestParam("initiationLrc") Integer initiationLrc,
            @RequestParam("remark") String remark){
        Upload upload = new Upload();
        InitiationUrl initiationUrl = new InitiationUrl();
        Lrc lrc = new Lrc();
        lrc.setLrcId(initiationLrc);
        initiationUrl.setInitiationUrl(upload.upload(multipartFile,request));
        initiationUrl.setInitiationUrlType(initiationUrlType);
        initiationUrl.setInitiationUrlName(initiationUrlName);
        initiationUrl.setInitiationUrlTitle(initiationUrlTitle);
        initiationUrl.setInitiationUrlDescribe(initiationUrlDescribe);
        initiationUrl.setLrc(lrc);
        initiationUrl.setRemark(remark);
        return SbsResult.success(initiationUrlService.insertInitiationUrl(initiationUrl));
    }


//    删除数据
    @RequestMapping("/deleteInitiationUrl")
    public SbsResult deleteInitiationUrl(@RequestParam("initiationUrlId") Integer initiationUrlId){
//        先判断是否被别的表关联
        Initiation initiations = initiationService.selectInitiationByUrlId(initiationUrlId);
        if (initiations != null){
            int row1 = initiationService.deleteInitiation(initiations.getInitiationId());
            int row2 = initiationUrlService.deleteInitiationUrl(initiationUrlId);
            if (row1 != 0 && row2 != 0){
                return SbsResult.success();
            }else{
                return SbsResult.fail("500","删除失败");
            }
        }else {
            int row1 = initiationUrlService.deleteInitiationUrl(initiationUrlId);
            if (row1 != 0){
                return SbsResult.success();
            }else{
                return SbsResult.fail("500","删除失败");
            }
        }
    }

}
