package com.systop.sbs.api;

import com.systop.sbs.common.util.ReadFile;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.InitiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/8 20:10
 **/
@RequestMapping("/api")
@RestController
@CrossOrigin
public class InitiationUrlApi {

    @Autowired
    InitiationService initiationService;

    @RequestMapping("/readLrc")
    public SbsResult readLrc(@RequestParam("initiationLrc") String initiationLrc){
        if (initiationLrc != null && initiationLrc != "") {
            ReadFile readFile = new ReadFile();
            return SbsResult.success(readFile.getFromAssets(initiationLrc));
        }
        return SbsResult.fail("500","没有数据");
    }
}
