package com.systop.sbs.api;

import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.CampusDynamicService;
import com.systop.sbs.service.CampusDynamicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/4 12:31
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/campusDynamic")
public class CampusDynamicApi {
    @Autowired
    CampusDynamicService campusDynamicService;
    @Autowired
    CampusDynamicTypeService campusDynamicTypeService;

    /**
     * 查询所有校园动态类型信息
     * @return SbsResult
     */
    @GetMapping("/campusDynamicTypeList")
    public SbsResult campusDynamicTypeList(){
        if (campusDynamicTypeService.searchCampusDynamicTypeList().size() == 0){
            return SbsResult.fail("300","暂无数据");
        } else {
            return SbsResult.success(campusDynamicTypeService.searchCampusDynamicTypeList());
        }
    }

    /**
     * 根据类型查询校园动态信息
     * @param campusDynamicTypeId 类型id
     * @return
     */
    @PostMapping("/campusDynamicListByType")
    public SbsResult campusDynamicListByType(@RequestParam("campusDynamicTypeId") Integer campusDynamicTypeId){
        if (campusDynamicService.campusDynamicListByType(campusDynamicTypeId).size() == 0){
            return SbsResult.fail("300","暂无数据");
        } else {
            return SbsResult.success(campusDynamicService.campusDynamicListByType(campusDynamicTypeId));
        }
    }
}
