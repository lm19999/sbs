package com.systop.sbs.service;

import com.systop.sbs.common.pojo.CampusDynamicCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/3 18:01
 **/
public interface CampusDynamicCollectService {

    /*==========================老师点赞相关=======================*/

    /**
     * 老师点赞信息添加
     * @param campusDynamicCollect
     * @return
     */
    Integer teaCollect(CampusDynamicCollect campusDynamicCollect);

    /**
     * 修改老师点赞状态
     * @param teaNo 教师工号
     * @param campusDynamicId 校园动态id
     * @param collectState 点赞状态
     * @return
     */
    Integer updateTeaState(@Param("teaNo") String teaNo, @Param("campusDynamicId") Integer campusDynamicId,
                           @Param("collectState") Integer collectState);

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
     * @param parId 家长id
     * @param campusDynamicId 校园动态id
     * @param collectState 点赞状态
     * @return
     */
    Integer updateParState(@Param("parId") Integer parId,@Param("campusDynamicId") Integer campusDynamicId,
                           @Param("collectState") Integer collectState);

    /**
     * 根据家长id查找点赞记录
     * @param parId 家长id
     * @return
     */
    List<CampusDynamicCollect> parCollectList(@Param("parId") Integer parId);
}
