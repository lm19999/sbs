package com.systop.sbs.controller;

import com.systop.sbs.service.BannerService;
import com.systop.sbs.util.SbsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @RequestMapping("/selectAllBanner")
    public SbsResult selectAllBanner(){
        return SbsResult.success(bannerService.selectAllBanner());
    }

//    添加banner
//    public SbsResult insertBanner(@RequestParam("file") MultipartFile multipartFile, @RequestParam("bannerUrl") String bannerUrl,
//                                  @RequestParam("bannerLink") String bannerLink,@RequestParam("bannerStatus") Integer bannerStatus){
//
//    }

}
