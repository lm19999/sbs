package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.Teacher;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.common.util.UploadImage;
import com.systop.sbs.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Program: sbs
 * @Description: TODO teacher的controller
 * @Author: 贾小翠
 * @Date: 2020/7/30 10:03
 **/
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    public TeacherService teacherService;

    /**
     * 查询所有教师信息
     * @return list
     */
    @GetMapping("/teacherList")
    public SbsResult searchTeacherList(){
        return SbsResult.success(teacherService.searchTeacherList());
    }

    /**
     * 删除教师信息
     * @param teaNo 教师工号
     * @return  0,删除失败;1,删除成功
     */
    @PostMapping("/delTeacher")
    public SbsResult deleteTeacher(@RequestParam("teaNo") String teaNo){
        return SbsResult.success(teacherService.deleteTeacher(teaNo));
    }

    /**
     * 添加教师信息
     * @param teaNo 教师工号
     * @param teaName 教师姓名
     * @param teaPwd 密码
     * @param teaPortrait 头像
     * @param teaType 类型
     * @param remark 备注
     * @return  0,添加失败;1,添加成功
     */
    @PostMapping("/addTeacher")
    public SbsResult addTeacher(@RequestParam("teaNo") String teaNo, @RequestParam("teaName") String teaName,
                                @RequestParam("teaPwd") String teaPwd, @RequestParam("teaPortrait") MultipartFile teaPortrait,
                                 @RequestParam("teaType") Integer teaType,@RequestParam("remark") String remark){
        UploadImage uploadImage = new UploadImage();
        Teacher teacher = new Teacher();
        teacher.setTeaNo(teaNo);
        teacher.setTeaName(teaName);
        teacher.setTeaPwd(teaPwd);
        teacher.setTeaPortrait(uploadImage.uploadImage(teaPortrait,null,null));
        teacher.setTeaType(teaType);
        teacher.setRemark(remark);
        System.out.println(uploadImage.uploadImage(teaPortrait,null,null));
        return SbsResult.success(teacherService.addTeacher(teacher));
    }

    /**
     * 根据工号查询教师信息
     * @param teaNo 教师工号
     * @return  teacher
     */
    @PostMapping("/searchTeacherByTno")
    public SbsResult searchTeacherByTno(@RequestParam("teaNo") String teaNo){
        return SbsResult.success(teacherService.searchTeacherByTno(teaNo));
    }

    /**
     * 修改教师信息
     * @param teaNo 教师工号
     * @param teaName 教师姓名
     * @param teaPwd 密码
     * @param teaPortrait 头像
     * @param teaType 类型
     * @param remark 备注
     * @return 0,修改失败;1,修改成功
     */
    @PostMapping("/updateTeacher")
    public SbsResult updateTeacher(@RequestParam("teaNo") String teaNo, @RequestParam("teaName") String teaName,
                                   @RequestParam("teaPwd") String teaPwd, @RequestParam("teaPortrait") MultipartFile teaPortrait,
                                   @RequestParam("teaType") Integer teaType,@RequestParam("remark") String remark){
        UploadImage uploadImage = new UploadImage();
        Teacher teacher = new Teacher();
        teacher.setTeaNo(teaNo);
        teacher.setTeaName(teaName);
        teacher.setTeaPwd(teaPwd);
        teacher.setTeaPortrait(uploadImage.uploadImage(teaPortrait,null,null));
        teacher.setTeaType(teaType);
        teacher.setRemark(remark);
        System.out.println(uploadImage.uploadImage(teaPortrait,null,null));
        return SbsResult.success(teacherService.updateTeacher(teacher));
    }
}
