package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.Student;
import com.systop.sbs.mapper.StudentMapper;
import com.systop.sbs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: com.systop.sbs.service.impl
 * @Description: TODO
 * @Author: ZhangLi
 * @Date: 2020/7/29 16:21
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> allStu() {
        return studentMapper.allStu();
    }

    @Override
    public Student stuBySno(String sno) {
        return studentMapper.stuBySno(sno);
    }

    @Override
    public Integer addStu(Student student) {
        return studentMapper.addStu(student);
    }

    @Override
    public Integer updateStu(Student student) {
        return studentMapper.updateStu(student);
    }

    @Override
    public Integer delStu(String stuNo) {
        return studentMapper.delStu(stuNo);
    }
}
