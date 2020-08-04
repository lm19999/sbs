package com.systop.sbs.service;

import com.systop.sbs.common.pojo.GrowthRecordCollect;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/4 9:57
 **/
public interface GrowthRecordCollectService {

    /*==========================老师点赞相关=======================*/

    /**
     * 老师点赞信息添加
     * @param growthRecordCollect 成长记录点赞
     * @return
     */
    Integer teaGRCollect(GrowthRecordCollect growthRecordCollect);

    /**
     * 修改老师点赞状态
     * @param teaNo 教师工号
     * @param growthRecordId 成长记录id
     * @param collectState 点赞状态
     * @return
     */
    Integer updateTeaGRState(@Param("teaNo") String teaNo, @Param("growthRecordId") Integer growthRecordId,
                             @Param("collectState") Integer collectState);

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
     * @param parId 家长id
     * @param growthRecordId 成长记录id
     * @param collectState 点赞状态
     * @return
     */
    Integer updateParGRState(@Param("parId") Integer parId,@Param("growthRecordId") Integer growthRecordId,
                             @Param("collectState") Integer collectState);

    /**
     * 根据家长id查找点赞记录
     * @param parId 家长id
     * @return
     */
    List<GrowthRecordCollect> parGRCollectList(@Param("parId") Integer parId);
}
