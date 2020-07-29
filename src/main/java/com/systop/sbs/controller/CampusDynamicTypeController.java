package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.CampusDynamicType;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.CampusDynamicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: sbs
 * @Description: TODO 校园动态类型controller
 * @Author: 贾小翠
 * @Date: 2020/7/28 15:09
 **/
@RestController
@RequestMapping("/campusDynamicType")
public class CampusDynamicTypeController {

    @Autowired
    public CampusDynamicTypeService campusDynamicTypeService;

    /**
     * 查询所有校园动态类型信息
     * @return SbsResult
     */
    @RequestMapping("/campusDynamicTypeList")
    public SbsResult searchCampusDynamicTypeList(){
        return SbsResult.success(campusDynamicTypeService.searchCampusDynamicTypeList());
    }

    /**
     * 删除校园动态类型信息
     * @param campusDynamicTypeId 校园动态类型Id
     * @return SbsResult
     */
    @RequestMapping("/delCampusDynamicType")
    public SbsResult deleteCampusDynamicType(@RequestParam("campusDynamicTypeId") Integer campusDynamicTypeId){
        return SbsResult.success(campusDynamicTypeService.deleteCampusDynamicType(campusDynamicTypeId));
    }

    /**
     * 添加校园动态类型信息
     * @param campusDynamicTypeName  校园动态类型名称
     * @param remark  备注
     * @return SbsResult
     */
    @RequestMapping("/addCampusDynamicType")
    public SbsResult addCampusDynamicType(@RequestParam("campusDynamicTypeName") String campusDynamicTypeName,@RequestParam("remark") String remark){
        CampusDynamicType campusDynamicType = new CampusDynamicType();
        campusDynamicType.setCampusDynamicTypeName(campusDynamicTypeName);
        campusDynamicType.setRemark(remark);
        return SbsResult.success(campusDynamicTypeService.addCampusDynamicType(campusDynamicType));
    }

    /**
     * 根据id查询校园动态类型信息
     * @param campusDynamicTypeId 校园动态类型Id
     * @return SbsResult
     */
    @RequestMapping("/searchCampusDynamicTypeById")
    public SbsResult searchCampusDynamicTypeById(@RequestParam("campusDynamicTypeId") Integer campusDynamicTypeId){
        return SbsResult.success(campusDynamicTypeService.searchCampusDynamicTypeById(campusDynamicTypeId));
    }

    /**
     * 修改校园动态类型信息
     * @param campusDynamicTypeName 校园动态类型名称
     * @param remark 备注
     * @param campusDynamicTypeId 校园动态类型Id
     * @return SbsResult
     */
    @RequestMapping("/updateCampusDynamicType")
    public SbsResult updateCampusDynamicType(@RequestParam("campusDynamicTypeName") String campusDynamicTypeName,@RequestParam("remark") String remark,
                                             @RequestParam("campusDynamicTypeId") Integer campusDynamicTypeId){
        CampusDynamicType campusDynamicType = new CampusDynamicType();
        campusDynamicType.setCampusDynamicTypeId(campusDynamicTypeId);
        campusDynamicType.setCampusDynamicTypeName(campusDynamicTypeName);
        campusDynamicType.setRemark(remark);
        return SbsResult.success(campusDynamicTypeService.updateCampusDynamicType(campusDynamicType));
    }
}
