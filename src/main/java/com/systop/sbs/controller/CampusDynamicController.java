package com.systop.sbs.controller;

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
        return SbsResult.success(campusDynamicService.searchCampusDynamicList());
    }

    /**
     * 查询官方新闻
     * @return list
     */
    @GetMapping("/officialNewsList")
    public SbsResult officialNewsList(){
        return SbsResult.success(campusDynamicService.officialNewsList());
    }

    /**
     * 查询活动动态
     * @return list
     */
    @GetMapping("/activityList")
    public SbsResult activityList(){
        return SbsResult.success(campusDynamicService.activityList());
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
}
