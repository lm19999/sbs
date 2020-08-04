package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.GrowthRecordCollect;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/4 9:43
 **/
@Mapper
public interface GrowthRecordCollectMapper {

    /*==========================老师点赞相关=======================*/

    /**
     * 老师点赞信息添加
     * @param growthRecordCollect 成长记录点赞
     * @return
     */
    @Insert("insert into growth_record_collect (par_id,tea_no,growth_record_id,collect_state,remark) " +
            "values (#{null},#{teacher.teaNo},#{growthRecord.growthRecordId},1,#{null})")
    Integer teaGRCollect(GrowthRecordCollect growthRecordCollect);

    /**
     * 修改老师点赞状态
     * @param teaNo 教师工号
     * @param growthRecordId 成长记录id
     * @param collectState 点赞状态
     * @return
     */
    @Update("update growth_record_collect set collect_state=#{collectState} " +
            "where tea_no=#{teacher.teaNo} and growth_record_id=#{growthRecord.growthRecordId}")
    Integer updateTeaGRState(@Param("teaNo") String teaNo, @Param("growthRecordId") Integer growthRecordId,
                           @Param("collectState") Integer collectState);

    /**
     * 根据教师工号查找点赞记录
     * @param teaNo 教师工号
     * @return
     */
    @Select("select * from growth_record_collect " +
            "where tea_no=#{teaNo}")
    List<GrowthRecordCollect> teaGRCollectList(@Param("teaNo") String teaNo);

    /*==========================家长点赞相关=======================*/

    /**
     * 家长点赞信息添加
     * @param growthRecordCollect
     * @return
     */
    @Insert("insert into growth_record_collect (par_id,tea_no,growth_record_id,collect_state,remark) " +
            "values (#{parents.parId},#{null},#{growthRecord.growthRecordId},1,#{null})")
    Integer parGRCollect(GrowthRecordCollect growthRecordCollect);

    /**
     * 修改家长点赞状态
     * @param parId 家长id
     * @param growthRecordId 成长记录id
     * @param collectState 点赞状态
     * @return
     */
    @Update("update growth_record_collect set collect_state=#{collectState} " +
            "where par_id=#{parents.parId} and growth_record_id=#{growthRecord.growthRecordId}")
    Integer updateParGRState(@Param("parId") Integer parId,@Param("growthRecordId") Integer growthRecordId,
                           @Param("collectState") Integer collectState);

    /**
     * 根据家长id查找点赞记录
     * @param parId 家长id
     * @return
     */
    @Select("select * from growth_record_collect " +
            "where par_id=#{parId}")
    List<GrowthRecordCollect> parGRCollectList(@Param("parId") Integer parId);
}
