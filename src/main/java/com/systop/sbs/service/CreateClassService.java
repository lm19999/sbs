package com.systop.sbs.service;

import com.systop.sbs.common.pojo.CreateClass;
import com.systop.sbs.mapper.CreateClassMapper;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/5 16:18
 **/
public interface CreateClassService {
//    查询每个老师创建的班级
    List<CreateClass> selectCreateTeacherByTeaNo(String teaNo);

//    创建群聊
    Integer insertCreateClass(CreateClass createClass);
}
