package com.systop.sbs.api;

import com.systop.sbs.common.pojo.Parents;
import com.systop.sbs.common.pojo.Teacher;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Program: com.systop.sbs.api
 * @Description: TODO
 * @Author: ZhangLi
 * @Date: 2020/8/3 18:59
 **/
@RestController
@CrossOrigin
@RequestMapping("/teacherApi")
public class TeacherApi {

    @Autowired
    private TeacherService teacherService;

    /**
     * 教师登录
     * @param teaNo 教师工号
     * @param teaPwd 教师密码
     * @param session
     * @return
     */
    @RequestMapping("/teacherLogin")
    public SbsResult teacherLogin(@Param("teaNo") String teaNo, @Param("teaPwd") String teaPwd, HttpSession session){
        Teacher teacher = teacherService.teaLogin(teaNo, teaPwd);
        if (teacher != null){
            teacher.setTeaOnlineStatus(0);
            teacherService.updateTeacher(teacher);
            session.setAttribute("teacherSession",teacher);
            return SbsResult.success(teacher);
        }else {
            return SbsResult.fail("500","没有数据");
        }
    }

    /**
     * 教师退出登录
     * @param session
     * @return
     */
    @RequestMapping("/teacherLogout")
    public SbsResult teacherLogout(HttpSession session){
        Teacher teacher =(Teacher) session.getAttribute("teacherSession");
        Teacher teacher1 = teacherService.searchTeacherByTno(teacher.getTeaNo());
        if (teacher1 != null){
            teacher1.setTeaOnlineStatus(1);
            teacherService.teacherLogout(teacher1);
            session.removeAttribute("teacherSession");
            return SbsResult.success(200,"成功");
        }else {
            return SbsResult.fail("500","没有数据");
        }
    }

    /**
     * session获取登录的用户并展示相应信息
     * @param session
     * @return
     */
    @RequestMapping("/showTeacherById")
    public SbsResult showTeacherById(HttpSession session){
        Teacher teacher =(Teacher) session.getAttribute("teacherSession");
        return SbsResult.success(teacherService.searchTeacherByTno(teacher.getTeaNo()));
    }
}
