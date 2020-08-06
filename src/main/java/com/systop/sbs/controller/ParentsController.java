package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.Parents;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.ParentsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/7/30 15:54
 **/
@RestController
@CrossOrigin(allowCredentials ="true",allowedHeaders = "*")
@RequestMapping("/parents")
public class ParentsController {

    @Autowired
    public ParentsService parentsService;

    /**
     * 查询所有家长信息
     * @return list
     */
    @GetMapping("/parentsList")
    public SbsResult searchParentsList(){
        return SbsResult.success(parentsService.searchParentsList());
    }

    /**
     * 删除家长信息
     * @param parId 家长Id
     * @return
     */
    @PostMapping("/delParents")
    public SbsResult deleteParents(@Param("parId") Integer parId){
        return SbsResult.success(parentsService.deleteParents(parId));
    }

    /**
     * 添加家长信息
     * @param parents 家长
     * @return
     */
    @PostMapping("/addParents")
    public SbsResult addParents(Parents parents){
        return SbsResult.success(parentsService.addParents(parents));
    }

    /**
     * 根据id查询家长信息
     * @param parId 家长Id
     * @return
     */
    @PostMapping("/searchParentsById")
    public SbsResult searchParentsById(@Param("parId") Integer parId){
        return SbsResult.success(parentsService.searchParentsById(parId));
    }

    /**
     * 修改家长信息
     * @param parents 家长
     * @return
     */
    @PostMapping("/updateParents")
    public SbsResult updateParents(Parents parents){
        return SbsResult.success(parentsService.updateParents(parents));
    }
}
