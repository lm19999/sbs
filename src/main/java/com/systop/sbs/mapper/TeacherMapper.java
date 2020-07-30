package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO teacher的mapper
 * @Author: 贾小翠
 * @Date: 2020/7/29 14:40
 **/
@Mapper
public interface TeacherMapper {

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
            "values (#{teaNo},#{teaName},#{teaPwd},#{teaPortrait},#{teaOnlineStatus},#{teaType},#{remark})")
    Integer addTeacher(Teacher teacher);

    /**
     * 修改教师信息
     * @param teacher 教师
     * @return
     */
    @Update("update teacher set tea_name=#{teaName},tea_pwd=#{teaPwd},tea_portrait=#{teaPortrait}," +
            "tea_online_status=#{teaOnlineStatus},tea_type=#{teaType},remark=#{remark} WHERE tea_no=#{teaNo}")
    Integer updateTeacher(Teacher teacher);


    /**
     * 根据工号查询教师信息
     * @param teaNo 教师工号
     * @return
     */
    @Select("select * from teacher where tea_no = #{teaNo}")
    Teacher searchTeacherByTno(@Param("teaNo") String teaNo);
}
