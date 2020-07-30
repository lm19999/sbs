package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: com.systop.sbs.mapper
 * @Description: TODO
 * @Author: ZhangLi
 * @Date: 2020/7/29 16:18
 **/
@Mapper
public interface StudentMapper {
    //查询所有学生
    @Select("select * from student")
    List<Student> allStu();

    //根据学号查找学生
    @Select("select * from student where stu_no=#{stuNo}")
    Student stuBySno(String stuNo);

    //添加学生
    @Insert("insert into student(stu_no,stu_name,stu_sex,stu_class,stu_birth,stu_address,remark) values" +
            "(#{stuNo},#{stuName},#{stuSex},#{stuClass},#{stuBirth},#{stuAddress},#{remark})")
    Integer addStu(Student student);

    //修改学生
    @Update("update student set " +
            "stu_no=#{stuNo},stu_name=#{stuName},stu_sex=#{stuSex},stu_class=#{stuClass}," +
            "stu_birth=#{stuBirth},stu_address=#{stuAddress},remark=#{remark}" +
            " where stu_no=#{stuNo}")
    Integer updateStu(Student student);

    //删除学生
    @Delete("delete from student where stu_no=#{stuNo}")
    Integer delStu(String stuNo);

}
