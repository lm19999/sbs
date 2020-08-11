package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.Banner;
import com.systop.sbs.common.util.UploadImage;
import com.systop.sbs.service.BannerService;
import com.systop.sbs.common.util.SbsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @RequestMapping("/selectAllBanner")
    public SbsResult selectAllBanner(){
        return SbsResult.success(bannerService.selectAllBanner());
    }


    /**
     * 按id查询相应的banner信息
     * return SbsResult
     * */
    @RequestMapping("/selectBannerById")
    public SbsResult selectBannerById(@RequestParam("bannerId") Integer bannerId){
        return SbsResult.success(bannerService.selectBannerById(bannerId));
    }


    //    添加banner
    @RequestMapping("/insertBanner")
    public SbsResult insertBanner(@RequestParam("file") MultipartFile multipartFile,
                                  @RequestParam("linkUrl") String linkUrl,@RequestParam("bannerStatus") Integer bannerStatus,
                                  @RequestParam("remark") String remark) throws IOException {
        UploadImage uploadImage = new UploadImage();
        Banner banner = new Banner();
        banner.setBannerUrl(uploadImage.uploadImage(multipartFile,null,null));
        banner.setLinkUrl(linkUrl);
        banner.setBannerStatus(bannerStatus);
        banner.setRemark(remark);
        System.out.println(uploadImage.uploadImage(multipartFile,null,null));
        return SbsResult.success(bannerService.insertBanner(banner));
    }


    //更新banner状态
    @RequestMapping("/updateBanner")
    public SbsResult updateBannerStatus(@RequestParam("bannerId") Integer bannerId,@RequestParam("bannerStatus") Integer bannerStatus){
        return SbsResult.success(bannerService.updateBanner(bannerId,bannerStatus));
    }

//    删除banner
    @RequestMapping("/deleteBanner")
    public SbsResult deleteBanner(@RequestParam("bannerId") Integer bannerId){
        return SbsResult.success(bannerService.deleteBanner(bannerId));
    }

//    更新banner数据
    @RequestMapping("/updateBannerOutImg")
    public SbsResult updateBannerOutImg(@RequestParam("bannerId") Integer bannerId,
                                        @RequestParam("linkUrl") String linkUrl,
                                        @RequestParam("bannerStatus") Integer bannerStatus,
                                        @RequestParam("remark") String remark){
        Banner banner = new Banner();
        banner.setBannerId(bannerId);
        banner.setLinkUrl(linkUrl);
        banner.setBannerStatus(bannerStatus);
        banner.setRemark(remark);

        if (bannerService.updateBannerOutImg(banner) == 0){
            return SbsResult.fail("500","没有数据");
        }else{
            return SbsResult.success(bannerService.updateBannerOutImg(banner));
        }

    }

}
