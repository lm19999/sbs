package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.CampusDynamic;
import com.systop.sbs.common.pojo.CampusDynamicType;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.CampusDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Program: sbs
 * @Description: TODO 校园动态的controller
 * @Author: 贾小翠
 * @Date: 2020/7/29 15:14
 **/
@RestController
@RequestMapping("/campusDynamic")
public class CampusDynamicController {

    @Autowired
    public CampusDynamicService campusDynamicService;

    /**
     * 查询所有校园动态信息
     * @return list
     */
    @GetMapping("/campusDynamicList")
    public SbsResult searchCampusDynamicList(){
        if (campusDynamicService.searchCampusDynamicList().size() == 0){
            return SbsResult.fail("500","暂时没有数据可展示");
        } else {
            return SbsResult.success(campusDynamicService.searchCampusDynamicList());
        }
    }

    /**
     * 查询官方新闻
     * @return list
     */
    @GetMapping("/officialNewsList")
    public SbsResult officialNewsList(){
        if (campusDynamicService.officialNewsList().size() == 0){
            return SbsResult.fail("500","暂时没有数据可展示");
        } else {
            return SbsResult.success(campusDynamicService.officialNewsList());
        }
    }

    /**
     * 查询活动动态
     * @return list
     */
    @GetMapping("/activityList")
    public SbsResult activityList(){
        if (campusDynamicService.activityList().size() == 0){
            return SbsResult.fail("500","暂时没有数据可展示");
        } else {
            return SbsResult.success(campusDynamicService.activityList());
        }
    }

    /**
     * 修改校园动态的发布状态
     * @param campusDynamicId   校园动态Id
     * @param campusDynamicStatus 校园动态状态
     * @return
     */
    @PostMapping("/updateStatus")
    public SbsResult updateStatus(@RequestParam("campusDynamicId") Integer campusDynamicId,
                                  @RequestParam("campusDynamicStatus") Integer campusDynamicStatus){
        return SbsResult.success(campusDynamicService.updateStatus(campusDynamicId,campusDynamicStatus));
    }

    /**
     * 删除校园动态信息
     * @param campusDynamicId 校园动态Id
     * @return
     */
    @PostMapping("/delCampusDynamic")
    public SbsResult deleteCampusDynamic(@RequestParam("campusDynamicId") Integer campusDynamicId){
        return SbsResult.success(campusDynamicService.deleteCampusDynamic(campusDynamicId));
    }

    /**
     * 添加校园动态信息
     * @param campusDynamicTypeId
     * @param campusDynamicName
//     * @param campusDynamicUrl
//     * @param campusDynamicDescribe
     * @param campusDynamicStatus
     * @param remark
     * @return
     */
    @PostMapping("/addCampusDynamic")
    public SbsResult addCampusDynamic(@RequestParam("campusDynamicTypeId") Integer campusDynamicTypeId,
                                      @RequestParam("campusDynamicName") String campusDynamicName,
//                                      @RequestParam("campusDynamicUrl") String campusDynamicUrl,
//                                      @RequestParam("campusDynamicDescribe") String campusDynamicDescribe,
                                      @RequestParam("campusDynamicStatus") Integer campusDynamicStatus,
                                      @RequestParam("remark") String remark){
        CampusDynamic campusDynamic = new CampusDynamic();
        CampusDynamicType campusDynamicType = new CampusDynamicType();
        campusDynamicType.setCampusDynamicTypeId(campusDynamicTypeId);
        campusDynamic.setCampusDynamicType(campusDynamicType);
        campusDynamic.setCampusDynamicName(campusDynamicName);
        /*campusDynamic.setCampusDynamicUrl(campusDynamicUrl);
        campusDynamic.setCampusDynamicDescribe(campusDynamicDescribe);*/
        campusDynamic.setCampusDynamicStatus(campusDynamicStatus);
        campusDynamic.setRemark(remark);
        return SbsResult.success(campusDynamicService.addCampusDynamic(campusDynamic));
    }

    /**
     * 根据id查询校园动态信息
     * @param campusDynamicId 校园动态Id
     * @return
     */
    @PostMapping("/searchCampusDynamicById")
    public SbsResult searchCampusDynamicById(@RequestParam("campusDynamicId") Integer campusDynamicId){
        return SbsResult.success(campusDynamicService.searchCampusDynamicById(campusDynamicId));
    }

    /**
     * 修改校园动态信息
     * @param
     * @return
     */
    @PostMapping("/updateCampusDynamic")
    public SbsResult updateCampusDynamic(@RequestParam("campusDynamicTypeId") Integer campusDynamicTypeId,
                                         @RequestParam("campusDynamicName") String campusDynamicName,
                                         @RequestParam("campusDynamicUrl") String campusDynamicUrl,
                                         @RequestParam("campusDynamicDescribe") String campusDynamicDescribe,
                                         @RequestParam("campusDynamicStatus") Integer campusDynamicStatus,
                                         @RequestParam("campusDynamicViews") Integer campusDynamicViews,
                                         @RequestParam("remark") String remark,
                                         @RequestParam("campusDynamicId") Integer campusDynamicId){
        CampusDynamic campusDynamic = new CampusDynamic();
        CampusDynamicType campusDynamicType = new CampusDynamicType();
        campusDynamicType.setCampusDynamicTypeId(campusDynamicTypeId);
        campusDynamic.setCampusDynamicId(campusDynamicId);
        campusDynamic.setCampusDynamicType(campusDynamicType);
        campusDynamic.setCampusDynamicName(campusDynamicName);
        campusDynamic.setCampusDynamicUrl(campusDynamicUrl);
        campusDynamic.setCampusDynamicDescribe(campusDynamicDescribe);
        campusDynamic.setCampusDynamicViews(campusDynamicViews);
        campusDynamic.setCampusDynamicStatus(campusDynamicStatus);
        campusDynamic.setRemark(remark);
        return SbsResult.success(campusDynamicService.updateCampusDynamic(campusDynamic));
    }
}
