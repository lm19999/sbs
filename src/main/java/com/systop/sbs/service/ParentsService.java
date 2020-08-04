package com.systop.sbs.service;

import com.systop.sbs.common.pojo.Parents;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO   parents的service
 * @Author: 贾小翠 张莉
 * @Date: 2020/7/29 14:34
 **/
public interface ParentsService {

    /**
     * 家长注册
     * @param parents 家长
     * @return
     */
    Integer registerParents(Parents parents);

    /**
     * 家长登录
     * @param parPhone 家长电话
     * @param parPwd  家长密码
     * @return
     */
    Parents parentsLogin(@Param("parPhone") String parPhone,@Param("parPwd") String parPwd);

    /**
     * 忘记密码
     * @param parPwd
     * @param parPhone
     * @return
     */
    Integer forgetParentsPwd(@Param("parPwd") String parPwd,@Param("parPhone") String parPhone);

    /**
     * 退出登录
     * @param parents
     * @return
     */
    Integer parentsLogout(Parents parents);

    /**
     * 查询所有家长信息
     * @return list
     */
    List<Parents> searchParentsList();

    /**
     * 删除家长信息
     * @param parId 家长Id
     * @return
     */
    Integer deleteParents(@Param("parId") Integer parId);

    /**
     * 添加家长信息
     * @param parents 家长
     * @return
     */
    Integer addParents(Parents parents);

    /**
     * 修改家长信息
     * @param parents 家长
     * @return
     */
    Integer updateParents(Parents parents);


    /**
     * 根据id查询家长信息
     * @param parId 家长Id
     * @return
     */
    Parents searchParentsById(@Param("parId") Integer parId);

    /**
     * 家长修改名称
     * @param parents
     * @return
     */
    Integer parentsChangeName(Parents parents);

    /**
     * 家长修改电话
     * @param parents
     * @return
     */
    Integer parentsChangePhone(Parents parents);

    /**
     * 家长修改头像
     * @param parents
     * @return
     */
    Integer parentsChangeTx(Parents parents);
}
