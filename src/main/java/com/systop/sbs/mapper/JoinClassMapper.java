package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.JoinClass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
}
