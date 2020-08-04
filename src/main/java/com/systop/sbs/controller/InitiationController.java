package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.Initiation;
import com.systop.sbs.common.pojo.InitiationType;
import com.systop.sbs.common.pojo.InitiationUrl;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.common.util.Upload;
import com.systop.sbs.common.util.UploadImage;
import com.systop.sbs.service.InitiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/30 11:24
 **/
@RestController
@CrossOrigin
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
    public SbsResult insertInitiation(
                                      @RequestParam("initiationTypeId") Integer initiationTypeId,
                                      @RequestParam("file") MultipartFile multipartFile,
                                      @RequestParam("initiationUrlId") Integer initiationUrlId,
                                      @RequestParam("initiationStatus") Integer initiationStatus,
                                      @RequestParam("remark") String remark
                                      ){
        Upload upload = new Upload();
        Initiation initiation = new Initiation();
        InitiationUrl initiationUrl = new InitiationUrl();
        InitiationType initiationType = new InitiationType();
        initiationType.setInitiationTypeId(initiationTypeId);
        initiation.setInitiationImg(UploadImage.uploadImage(multipartFile,null,null));
        initiationUrl.setInitiationUrlId(initiationUrlId);
        initiation.setInitiationUrl(initiationUrl);
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
