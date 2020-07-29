package com.systop.sbs.service;

import com.systop.sbs.common.pojo.Parents;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO   parents的service
 * @Author: 贾小翠
 * @Date: 2020/7/29 14:34
 **/
public interface ParentsService {

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
}
