package com.systop.sbs.service;

import com.systop.sbs.common.pojo.CampusDynamicCollect;
import com.systop.sbs.common.pojo.GrowthRecordCollect;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/3 18:01
 **/
public interface CampusDynamicCollectService {
    /*============================list===========================*/

    /**
     * 查询所有点赞
     * @return
     */
    List<CampusDynamicCollect> campusDynamicCollectList();

    /**
     * 查询所有点赞
     * @return
     */
    List<CampusDynamicCollect> campusDynamicCollectListByCampus(@Param("campusDynamicId") Integer campusDynamicId);

    /**
     * 家长点赞list
     * @return
     */
    List<GrowthRecordCollect> parCampusCollectList();

    /**
     * 教师点赞list
     * @return
     */
    List<GrowthRecordCollect> teaCampusCollectList();
    /*==========================老师点赞相关=======================*/

    /**
     * 老师点赞信息添加
     * @param campusDynamicCollect
     * @return
     */
    Integer teaCollect(CampusDynamicCollect campusDynamicCollect);

    /**
     * 修改老师点赞状态
     * @param campusDynamicCollect
     * @return
     */
    Integer updateTeaState(CampusDynamicCollect campusDynamicCollect);

    /**
     * 根据教师工号查找点赞记录
     * @param teaNo 教师工号
     * @return
     */
    List<CampusDynamicCollect> teaCollectList(@Param("teaNo") String teaNo);

    /*==========================家长点赞相关=======================*/

    /**
     * 家长点赞信息添加
     * @param campusDynamicCollect
     * @return
     */
    Integer parCollect(CampusDynamicCollect campusDynamicCollect);

    /**
     * 修改家长点赞状态
     * @param campusDynamicCollect
     * @return
     */
    Integer updateParState(CampusDynamicCollect campusDynamicCollect);

    /**
     * 根据家长id查找点赞记录
     * @param parId 家长id
     * @return
     */
    List<CampusDynamicCollect> parCollectList(@Param("parId") Integer parId);
}
