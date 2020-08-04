package com.systop.sbs.service;

import com.systop.sbs.common.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO teacher的Service
 * @Author: 贾小翠 张莉
 * @Date: 2020/7/29 14:50
 **/
public interface TeacherService {

    /**
     * 教师登录
     * @param teaNo 教师工号
     * @param teaPwd 教师密码
     * @return
     */
    Teacher teaLogin(@Param("teaNo") String teaNo,@Param("teaPwd") String teaPwd);

    /**
     * 教师退出登录
     * @param teacher
     * @return
     */
    Integer teacherLogout(Teacher teacher);

    /**
     * 查询所有教师信息
     * @return list
     */
    List<Teacher> searchTeacherList();

    /**
     * 删除教师信息
     * @param teaNo 教师工号
     * @return  0,删除失败;1,删除成功
     */
    Integer deleteTeacher(@Param("teaNo") String teaNo);

    /**
     * 添加教师信息
     * @param teacher 教师
     * @return  0,添加失败;1,添加成功
     */
    Integer addTeacher(Teacher teacher);

    /**
     * 修改教师信息
     * @param teacher 教师
     * @return  0,修改失败;1,修改成功
     */
    Integer updateTeacher(Teacher teacher);


    /**
     * 根据工号查询教师信息
     * @param teaNo 教师工号
     * @return  teacher
     */
    Teacher searchTeacherByTno(@Param("teaNo") String teaNo);

    /**
     * 教师修改姓名
     * @param teacher
     * @return
     */
    Integer teacherChangeName(Teacher teacher);


    /**
     * 教师修改头像
     * @param teacher
     * @return
     */
    Integer teacherChangeTx(Teacher teacher);
}
