package com.systop.sbs.api;

import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.mapper.BannerMapper;
import com.systop.sbs.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/4 14:05
 **/
@CrossOrigin
@RestController
@RequestMapping("/api")
public class BannerApi {

    @Autowired
    BannerService bannerService;

    @RequestMapping("/selectAllBannerByStatus")
    public SbsResult selectALLBanner(){
        if (bannerService.selectAllBannerByStatus().size()<=0){
            return SbsResult.fail("500","没有数据");
        }else{
            return SbsResult.success(bannerService.selectAllBannerByStatus());
        }
    }
}
