package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.Teacher;
import com.systop.sbs.mapper.TeacherMapper;
import com.systop.sbs.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO teacher的ServiceImpl
 * @Author: 贾小翠
 * @Date: 2020/7/29 14:53
 **/
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher teaLogin(String teaNo, String teaPwd) {
        return teacherMapper.teaLogin(teaNo, teaPwd);
    }

    @Override
    public Integer teacherLogout(Teacher teacher) {
        return teacherMapper.teacherLogout(teacher);
    }

    @Override
    public List<Teacher> searchTeacherList() {
        return teacherMapper.searchTeacherList();
    }

    @Override
    public Integer deleteTeacher(String teaNo) {
        return teacherMapper.deleteTeacher(teaNo);
    }

    @Override
    public Integer addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public Integer updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public Teacher searchTeacherByTno(String teaNo) {
        return teacherMapper.searchTeacherByTno(teaNo);
    }
}
