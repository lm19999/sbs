package com.systop.sbs.api;

import com.systop.sbs.common.pojo.CreateClass;
import com.systop.sbs.common.pojo.JoinClass;
import com.systop.sbs.common.pojo.Parents;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.JoinClassService;
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

    public SbsResult JoinClass(@RequestParam("classNum") String class_num,
                               @RequestParam("parId") Integer parId,@RequestParam("remark") String remark){
        JoinClass joinClass = new JoinClass();
        CreateClass createClass = new CreateClass();
        createClass.setClassNum(class_num);
        Parents parents = new Parents();
        parents.setParId(parId);
        joinClass.setCreateClass(createClass);
        joinClass.setParents(parents);
        joinClass.setRemark(remark);
        if (joinClassService.joinClass(joinClass) == 0){
            return SbsResult.fail("500","没有数据");
        }else{
            return SbsResult.success(joinClassService.joinClass(joinClass));
        }

    }
}
