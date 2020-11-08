package com.systop.sbs.api;

import com.systop.sbs.common.pojo.CreateClass;
import com.systop.sbs.common.pojo.JoinClass;
import com.systop.sbs.common.pojo.Parents;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.JoinClassService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/6 16:45
 **/
@RestController
@CrossOrigin
@RequestMapping("/api")
public class JoinClassApi {

    @Autowired
    JoinClassService joinClassService;

    /**
     *  加入班级方法
     **/
    @RequestMapping("/joinClass")
    public SbsResult JoinClass(@RequestParam("classNum") String class_num,
                               @RequestParam("parId") Integer parId,@Param("remark") String remark){
        JoinClass joinClass = new JoinClass();
        CreateClass createClass = new CreateClass();
        createClass.setClassNum(class_num);
        Parents parents = new Parents();
        parents.setParId(parId);
        joinClass.setCreateClass(createClass);
        joinClass.setParents(parents);
        joinClass.setRemark(remark);
        return SbsResult.success(joinClassService.joinClass(joinClass));
    }


    /**
     * 查询所有加入的班级（家长的方法）
     * */
    @RequestMapping("/selectAllJoinClass")
    public SbsResult selectAllJoinClass(@RequestParam("parId") Integer parId){
        return SbsResult.success(joinClassService.selectAllJoinClass(parId));
    }

    /**
     * 查询此家长是否已经加入此班级
     * */
    @RequestMapping("/selectTrue")
    public SbsResult selectTrue(@RequestParam("classNum") String classNum,@RequestParam("parId") Integer parId){
        return SbsResult.success(joinClassService.selectTrue(classNum,parId));
    }
}
