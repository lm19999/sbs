package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.JoinClass;
import org.apache.ibatis.annotations.*;

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
    @Results({
            @Result(property = "createClass", column = "class_num",
                    one = @One(select = "com.systop.sbs.mapper.CreateClassMapper.selectClassByClassNum")),
            @Result(property = "parents", column = "par_id",
                    one = @One(select = "com.systop.sbs.mapper.ParentsMapper.searchParentsById"))
    })
    List<JoinClass> selectAllJoinClass(Integer parId);

//    查询此班级此家长是否加入过
    @Select("select * from join_class where class_num=#{0} and par_id=#{1}")
    @Results({
            @Result(property = "createClass", column = "class_num",
                    one = @One(select = "com.systop.sbs.mapper.CreateClassMapper.selectClassByClassNum")),
            @Result(property = "parents", column = "par_id",
                    one = @One(select = "com.systop.sbs.mapper.ParentsMapper.searchParentsById"))
    })
    JoinClass selectTrue(String classNum,Integer parId);
}
