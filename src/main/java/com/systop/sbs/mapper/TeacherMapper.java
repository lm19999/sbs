package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO teacher的mapper
 * @Author: 贾小翠 张莉
 * @Date: 2020/7/29 14:40
 **/
@Mapper
public interface TeacherMapper {

    /**
     * 教师登录
     * @param teaNo 教师工号
     * @param teaPwd 教师密码
     * @return
     */
    @Select("select * from teacher where tea_no=#{teaNo} and tea_pwd=#{teaPwd} and tea_type=1")
    Teacher teaLogin(@Param("teaNo") String teaNo,@Param("teaPwd") String teaPwd);

    /**
     * 退出登录
     * @param teacher
     * @return
     */
    @Update("update teacher set tea_online_status=1 WHERE tea_no=#{teaNo}")
    Integer teacherLogout(Teacher teacher);

    /**
     * 查询所有教师信息
     * @return list
     */
    @Select("select * from teacher WHERE tea_type=1")
    List<Teacher> searchTeacherList();

    /**
     * 删除教师信息
     * @param teaNo 教师工号
     * @return
     */
    @Delete("delete from teacher where tea_no=#{teaNo}")
    Integer deleteTeacher(@Param("teaNo") String teaNo);

    /**
     * 添加教师信息
     * @param teacher 教师
     * @return
     */
    @Insert("insert into teacher (tea_no,tea_name,tea_pwd,tea_portrait,tea_online_status,tea_type,remark) " +
            "values (#{teaNo},#{teaName},#{teaPwd},#{teaPortrait},0,#{teaType},#{remark})")
    Integer addTeacher(Teacher teacher);

    /**
     * 修改教师信息
     * @param teacher 教师
     * @return
     */
    @Update("update teacher set tea_name=#{teaName},tea_pwd=#{teaPwd},tea_portrait=#{teaPortrait}," +
            "tea_online_status=0,tea_type=#{teaType},remark=#{remark} WHERE tea_no=#{teaNo}")
    Integer updateTeacher(Teacher teacher);


    /**
     * 根据工号查询教师信息
     * @param teaNo 教师工号
     * @return
     */
    @Select("select * from teacher where tea_no = #{teaNo}")
    Teacher searchTeacherByTno(@Param("teaNo") String teaNo);

    /**
     * 教师修改姓名
     * @param teacher
     * @return
     */
    @Update("update teacher set tea_name=#{teaName} WHERE tea_no=#{teaNo}")
    Integer teacherChangeName(Teacher teacher);


    /**
     * 教师修改头像
     * @param teacher
     * @return
     */
    @Update("update teacher set tea_portrait=#{teaPortrait} WHERE tea_no=#{teaNo}")
    Integer teacherChangeTx(Teacher teacher);
}
