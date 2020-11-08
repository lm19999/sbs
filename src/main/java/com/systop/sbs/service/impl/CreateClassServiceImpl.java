package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.CreateClass;
import com.systop.sbs.mapper.CreateClassMapper;
import com.systop.sbs.service.CreateClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/5 16:21
 **/
@Service
public class CreateClassServiceImpl implements CreateClassService {
    @Autowired
    CreateClassMapper classMapper;

    @Override
    public List<CreateClass> selectCreateTeacherByTeaNo(String teaNo) {
        return classMapper.selectCreateTeacherByTeaNo(teaNo);
    }

    @Override
    public Integer insertCreateClass(CreateClass createClass) {
        return classMapper.insertCreateClass(createClass);
    }

    @Override
    public CreateClass selectClassByClassNum(String classNum) {
        return classMapper.selectClassByClassNum(classNum);
    }
}
