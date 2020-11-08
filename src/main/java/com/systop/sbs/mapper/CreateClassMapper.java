package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.CreateClass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/5 16:09
 **/
@Mapper
public interface CreateClassMapper {
//    查询每个老师创建的群聊
    @Select("select * from create_class where tea_no = #{teaNo}")
    List<CreateClass> selectCreateTeacherByTeaNo(String teaNo);

//    创建群聊
    @Insert("insert into create_class (class_name,class_code,class_num,class_img,tea_no,class_time,class_size,remark) " +
            "values (#{className},#{classCode},#{classNum},#{classImg},#{teacher.teaNo},now(),#{classSize},#{remark})")
    Integer insertCreateClass(CreateClass createClass);

//    按班级号查询数据
    @Select("select * from create_class where class_num=#{classNum}")
    CreateClass selectClassByClassNum(String classNum);
}
