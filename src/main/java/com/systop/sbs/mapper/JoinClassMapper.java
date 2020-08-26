package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.JoinClass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/6 16:32
 **/
@Mapper
public interface JoinClassMapper {

//    加入群聊
    @Insert("insert into join_class (class_num,par_id,remark) values (#{createClass.classNum},#{parents.parId},#{remark})")
    Integer joinClass(JoinClass joinClass);

//    查询加入的所有群聊（家长的方法）
    @Select("select * from join_class where par_id =#{parId}")
    List<JoinClass> selectAllJoinClass(Integer parId);
}
