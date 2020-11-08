package com.systop.sbs.api;

import com.systop.sbs.common.util.QRCodeUtil;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.InitiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/3 8:19
 **/
@RestController
@CrossOrigin
@RequestMapping("/api")
public class InitiationApi {
    @Autowired
    InitiationService initiationService;

    @RequestMapping("/selectAllInitiationByType")
    public SbsResult selectAllInitiationByType(@RequestParam("initiationTypeId") Integer initiationTypeId) {
        if (initiationService.selectAllInitiationByType(initiationTypeId).size() == 0) {
            return SbsResult.fail("300", "没有数据");
        } else {
            return SbsResult.success(initiationService.selectAllInitiationByType(initiationTypeId));
        }
    }

    /**
     * 前台搜索启蒙数据方法
     * */
    @RequestMapping("/selectAllInitiationByTypeAndName")
    public SbsResult selectAllInitiationByTypeAndName(@RequestParam("initiationTypeId") Integer initiationTypeId,
                                                      @RequestParam("initiationUrlName") String initiationUrlName){
        return SbsResult.success(initiationService.selectInitiationByTypeAndName(initiationTypeId,initiationUrlName));
    }


//    生成二维码测试
//    @GetMapping("/Qrcode")
//    public void productcode() {
//        QRCodeUtil.zxingCodeCreate("?id=123&name=456", "D:/picture/", 500, "");
//    }

}