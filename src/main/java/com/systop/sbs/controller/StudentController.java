package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.Student;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Program: com.systop.sbs.controller
 * @Description: TODO
 * @Author: ZhangLi
 * @Date: 2020/7/29 16:23
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查看所有学生信息
     * @return
     */
    @RequestMapping("/findAllStudent")
    public SbsResult findAllStudent(){
        return SbsResult.success(studentService.allStu());
    }

    /**
     * 根据学号查找学生
     * @param stuNo 学号
     * @return
     */
    @RequestMapping("/stuBySno")
    public SbsResult findStuBySno(@RequestParam("stuNo") String stuNo){
        return SbsResult.success(studentService.stuBySno(stuNo));
    }

    /**
     * 添加学生信息
     * @param stuNo   学号
     * @param stuName 姓名
     * @param stuSex  性别
     * @param stuClass 所属班级
     * @param stuBirth 出生日期
     * @param stuAddress 籍贯
     * @param remark 备注
     * @return
     */
    @RequestMapping("/addStudent")
    public SbsResult addStudent(@RequestParam("stuNo") String stuNo, @RequestParam("stuName") String stuName,
                                @RequestParam("stuSex") String stuSex, @RequestParam("stuClass") String stuClass,
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("stuBirth") Date stuBirth,
                                @RequestParam("stuAddress") String stuAddress,
                                @RequestParam("remark") String remark){
        Student student = new Student();
        student.setStuNo(stuNo);
        student.setStuName(stuName);
        student.setStuSex(stuSex);
        student.setStuClass(stuClass);
        student.setStuBirth(stuBirth);
        student.setStuAddress(stuAddress);
        student.setRemark(remark);
        return SbsResult.success(studentService.addStu(student));
    }

    /**
     * 修改学生信息
     * @param stuNo   学号
     * @param stuName 姓名
     * @param stuSex  性别
     * @param stuClass 所属班级
     * @param stuBirth 出生日期
     * @param stuAddress 籍贯
     * @param remark 备注
     * @return
     */
    @RequestMapping("/updateStu")
    public SbsResult updateStu(@RequestParam("stuNo") String stuNo, @RequestParam("stuName") String stuName,
                               @RequestParam("stuSex") String stuSex, @RequestParam("stuClass") String stuClass,
                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("stuBirth") Date stuBirth,
                               @RequestParam("stuAddress") String stuAddress,
                               @RequestParam("remark") String remark){
        Student student = new Student();
        student.setStuNo(stuNo);
        student.setStuName(stuName);
        student.setStuSex(stuSex);
        student.setStuClass(stuClass);
        student.setStuBirth(stuBirth);
        student.setStuAddress(stuAddress);
        student.setRemark(remark);
        return SbsResult.success(studentService.updateStu(student));
    }

    /**
     * 删除学生信息
     * @param stuNo 学号
     * @return
     */
    @RequestMapping("/delStu")
    public SbsResult delStu(@RequestParam("stuNo") String stuNo){
        return SbsResult.success(studentService.delStu(stuNo));
    }

    /**
     * 批量上传学生信息
     * @param file 文件
     * @return
     * @throws Exception
     */
    @RequestMapping("/batchImport")
    public SbsResult batchImport(MultipartFile file) throws Exception{
        int count = studentService.batchImport(file);
        return SbsResult.success(count);
    }


}
