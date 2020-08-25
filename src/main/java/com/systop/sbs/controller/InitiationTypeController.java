package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.Initiation;
import com.systop.sbs.common.pojo.InitiationType;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.InitiationService;
import com.systop.sbs.service.InitiationTypeService;
import com.systop.sbs.service.InitiationUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: sbs
 * @Description: 启蒙类型controller
 * @Author: liumiao
 * @Date: 2020/7/29 20:57
 **/
@RestController
@CrossOrigin
@RequestMapping("/initiationType")
@Transactional
public class InitiationTypeController {

    @Autowired
    InitiationTypeService initiationTypeService;
    @Autowired
    InitiationService initiationService;
    @Autowired
    InitiationUrlService initiationUrlService;

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


/**
 * 先查询对应的表有没有相应的数据，有的话，将所有关联着的数据删除
 * return SbsResult
 * */
    @RequestMapping("/deleteInitiationType")
    public SbsResult deleteInitiationType(@RequestParam("initiationTypeId") Integer initiationTypeId){
//        查询所有的对应的类型的数据
        List<Initiation> initiations = initiationService.selectInitiationByType(initiationTypeId);
        List<Integer> list = new ArrayList();
        if (initiations.size()>0){
            for (Initiation item: initiations) {
                list.add(initiationService.deleteInitiation(item.getInitiationId()));
            }
           int row  = initiationTypeService.deleteInitiationType(initiationTypeId);

            if (list.size()>0 && row >0){
                return SbsResult.success();
            }else{
                return SbsResult.fail("500","删除失败");
            }
        }else{
            int row  = initiationTypeService.deleteInitiationType(initiationTypeId);
            if (row >0){
                return SbsResult.success();
            }else{
                return SbsResult.fail("500","删除失败");
            }
        }



    }
}
