package com.systop.sbs.service;

import com.systop.sbs.common.pojo.JoinClass;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/6 16:41
 **/
public interface JoinClassService {
//    加入群聊
    Integer joinClass(JoinClass joinClass);
//    查询加入的所有群聊（家长的方法）
    List<JoinClass> selectAllJoinClass(Integer parId);
//    查询此班级此家长是否加入过
    JoinClass selectTrue(String classNum,Integer parId);
}
