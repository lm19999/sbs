package com.systop.sbs.service;

import com.systop.sbs.common.pojo.GrowthRecordCollect;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/4 9:57
 **/
public interface GrowthRecordCollectService {
    /*============================list===========================*/

    /**
     * 查询所有点赞
     * @return
     */
    List<GrowthRecordCollect> growthRecordCollectList();


    /**
     * 根据成长记录查询点赞
     * @return
     */
    List<GrowthRecordCollect> growthRecordCollectListByGrowthRecord(@Param("growthRecordId") Integer growthRecordId);

    /**
     * 删除成长记录点赞
     * @param growthRecordId 成长记录Id
     * @return
     */
    Integer deleteGrowthRecordCollect(@Param("growthRecordId") Integer growthRecordId);

    /**
     * 家长点赞list
     * @return
     */
    List<GrowthRecordCollect> parGrowthRecordCollectList();

    /**
     * 教师点赞list
     * @return
     */
    List<GrowthRecordCollect> teaGrowthRecordCollectList();

    /*==========================老师点赞相关=======================*/

    /**
     * 老师点赞信息添加
     * @param growthRecordCollect 成长记录点赞
     * @return
     */
    Integer teaGRCollect(GrowthRecordCollect growthRecordCollect);

    /**
     * 修改老师点赞状态
     * @param growthRecordCollect
     * @return
     */
    Integer updateTeaGRState(GrowthRecordCollect growthRecordCollect);

    /**
     * 根据教师工号查找点赞记录
     * @param teaNo 教师工号
     * @return
     */
    List<GrowthRecordCollect> teaGRCollectList(@Param("teaNo") String teaNo);

    /*==========================家长点赞相关=======================*/

    /**
     * 家长点赞信息添加
     * @param growthRecordCollect
     * @return
     */
    Integer parGRCollect(GrowthRecordCollect growthRecordCollect);

    /**
     * 修改家长点赞状态
     * @param growthRecordCollect
     * @return
     */
    Integer updateParGRState(GrowthRecordCollect growthRecordCollect);

    /**
     * 根据家长id查找点赞记录
     * @param parId 家长id
     * @return
     */
    List<GrowthRecordCollect> parGRCollectList(@Param("parId") Integer parId);
}
