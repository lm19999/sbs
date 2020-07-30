package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.Initiation;
import com.systop.sbs.common.pojo.InitiationType;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.common.util.Upload;
import com.systop.sbs.service.InitiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/30 11:24
 **/
@RestController
@RequestMapping("/initiation")
public class InitiationController {

    @Autowired
    InitiationService initiationService;

    @RequestMapping("/selectAllInitiation")
    public SbsResult selectAllInitiation(){
        if (initiationService.selectAllInitiation().size() == 0){
            return SbsResult.fail("500","没有数据");
        }else {
            return SbsResult.success(initiationService.selectAllInitiation());
        }
    }

    @RequestMapping("/insertInitiation")
    public SbsResult insertInitiation(@RequestParam("initiationTitle") String initiationTitle,
                                      @RequestParam("initiationTypeId") Integer initiationTypeId,
                                      @RequestParam("initiationName") String initiationName,
                                      @RequestParam("file") MultipartFile multipartFile,HttpServletRequest request,
                                      @RequestParam("initiationDescribe") String initiationDescribe,
                                      @RequestParam("initiationStatus") Integer initiationStatus,
                                      @RequestParam("remark") String remark
                                      ){
        Upload upload = new Upload();
        Initiation initiation = new Initiation();
        InitiationType initiationType = new InitiationType();
        initiationType.setInitiationTypeId(initiationTypeId);
        initiation.setInitiationTitle(initiationTitle);
        initiation.setInitiationName(initiationName);
        initiation.setInitiationUrl(upload.upload(multipartFile,request));
        initiation.setInitiationDescribe(initiationDescribe);
        initiation.setInitiationStatus(initiationStatus);
        initiation.setRemark(remark);
        initiation.setInitiationType(initiationType);
        return SbsResult.success(initiationService.insertInitiation(initiation));
    }

    @RequestMapping("/deleteInitiation")
    public SbsResult deleteInitiation(@RequestParam("initiationId") Integer initiationId){
        if (initiationService.deleteInitiation(initiationId) == 0){
            return SbsResult.fail("500","没有数据");
        }else{
            return SbsResult.success(initiationService.deleteInitiation(initiationId));
        }
    }
}
