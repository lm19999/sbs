package com.systop.sbs.service;

import com.systop.sbs.common.pojo.CampusDynamic;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO   校园动态的service
 * @Author: 贾小翠
 * @Date: 2020/7/29 11:50
 **/
public interface CampusDynamicService {

    /**
     * 查询所有校园动态信息
     * @return list
     */
    List<CampusDynamic> searchCampusDynamicList();

    /**
     * 查询官方新闻
     * @return list
     */
    List<CampusDynamic> officialNewsList();

    /**
     * 查询活动动态
     * @return list
     */
    List<CampusDynamic> activityList();

    /**
     * 删除校园动态信息
     * @param campusDynamicId 校园动态Id
     * @return
     */
    Integer deleteCampusDynamic(@Param("campusDynamicId") Integer campusDynamicId);

    /**
     * 添加校园动态信息
     * @param campusDynamic
     * @return
     */
    Integer addCampusDynamic(CampusDynamic campusDynamic);

    /**
     * 修改校园动态信息
     * @param campusDynamic 校园动态
     * @return
     */
    Integer updateCampusDynamic(CampusDynamic campusDynamic);

    /**
     * 修改校园动态的发布状态
     * @param campusDynamicId   校园动态Id
     * @param campusDynamicStatus 校园动态状态
     * @return
     */
    Integer updateStatus(@Param("campusDynamicId") Integer campusDynamicId,@Param("campusDynamicStatus") Integer campusDynamicStatus);

    /**
     * 根据id查询校园动态信息
     * @param campusDynamicId 校园动态Id
     * @return
     */
    CampusDynamic searchCampusDynamicById(@Param("campusDynamicId") Integer campusDynamicId);
}
