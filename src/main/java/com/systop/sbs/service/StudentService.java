package com.systop.sbs.service;

import com.systop.sbs.common.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Program: com.systop.sbs.service
 * @Description: TODO
 * @Author: ZhangLi
 * @Date: 2020/7/29 16:19
 **/
public interface StudentService {
    List<Student> allStu();

    Student stuBySno(@Param("sno") String sno);

    Integer addStu(Student student);

    Integer updateStu(Student student);

    Integer delStu(String stuNo);
}
