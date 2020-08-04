package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.InitiationType;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.InitiationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: sbs
 * @Description: 启蒙类型controller
 * @Author: liumiao
 * @Date: 2020/7/29 20:57
 **/
@RestController
@CrossOrigin
@RequestMapping("/initiationType")
public class InitiationTypeController {

    @Autowired
    InitiationTypeService initiationTypeService;

    @RequestMapping("/selectAllInitiationType")
    public SbsResult selectAll(){
        return SbsResult.success(initiationTypeService.selectAll());
    }

    @RequestMapping("/selectById")
    public SbsResult selectById(@RequestParam("initiationTypeId") Integer initiationTypeId){
        System.out.println(initiationTypeService.selectById(initiationTypeId));
        if (initiationTypeService.selectById(initiationTypeId) == null){
            return SbsResult.fail("500","no values");
        }else{
            return SbsResult.success(initiationTypeService.selectById(initiationTypeId));
        }
    }

    @RequestMapping("/insertInitiationType")
    public SbsResult insertInitiationType(@RequestParam("initiationTypeName") String initiationTypeName,@RequestParam("remark") String remark){
        InitiationType initiationType = new InitiationType();
        System.out.println(initiationTypeName);
        System.out.println(remark);
        initiationType.setInitiationTypeName(initiationTypeName);
        initiationType.setRemark(remark);
        return SbsResult.success(initiationTypeService.insertInitiationType(initiationType));
    }

    @RequestMapping("/updateInitiationType")
    public SbsResult updateInitiationType(@RequestParam("initiationTypeId") Integer initiationTypeId,@RequestParam("initiationTypeName") String initiationTypeName,@RequestParam("remark") String remark){
        InitiationType initiationType = new InitiationType();
        initiationType.setInitiationTypeName(initiationTypeName);
        initiationType.setRemark(remark);
        initiationType.setInitiationTypeId(initiationTypeId);
        return  SbsResult.success(initiationTypeService.updateInitiationType(initiationType));
    }

    @RequestMapping("/deleteInitiationType")
    public SbsResult deleteInitiationType(@RequestParam("initiationTypeId") Integer initiationTypeId){
        if (initiationTypeService.deleteInitiationType(initiationTypeId) != null){
            return SbsResult.success(initiationTypeService.deleteInitiationType(initiationTypeId));
        }else{
            return SbsResult.fail("500","删除失败");
        }
    }
}
