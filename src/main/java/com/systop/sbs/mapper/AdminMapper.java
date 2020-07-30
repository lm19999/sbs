package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/29 16:07
 **/

@Mapper
public interface AdminMapper {
//    管理员登录
    @Select("select * from teacher where tea_no=#{0} and tea_pwd=#{1} and tea_type=0")
    Teacher adminlogin(String username,String password);
}
