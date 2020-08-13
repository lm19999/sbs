package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.CampusDynamicCollect;
import com.systop.sbs.common.pojo.GrowthRecordCollect;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/4 9:43
 **/
@Mapper
public interface GrowthRecordCollectMapper {
    /*============================list===========================*/

    /**
     * 查询所有点赞
     * @return
     */
    @Select("select * from growth_record_collect")
    @Results(id = "growthRecordCollectMap",value = {
            @Result(id = true, column = "growth_record_collect_id", property = "growthRecordCollectId"),
            @Result(column = "collect_state", property = "collectState"),
            @Result(column = "remark", property = "remark"),
            @Result(property = "parents", column = "par_id",
                    one = @One(select = "com.systop.sbs.mapper.ParentsMapper.searchParentsById",
                            fetchType = FetchType.LAZY)),
            @Result(property = "teacher", column = "tea_no",
                    one = @One(select = "com.systop.sbs.mapper.TeacherMapper.searchTeacherByTno",
                            fetchType = FetchType.LAZY)),
            @Result(property = "growthRecord", column = "growth_record_id",
                    one = @One(select = "com.systop.sbs.mapper.GrowthRecordMapper.searchGrowthRecordById",
                            fetchType = FetchType.LAZY))
    }
    )
    List<GrowthRecordCollect> growthRecordCollectList();

    /**
     * 家长点赞list
     * @return
     */
    @Select("select * from growth_record_collect WHERE par_id is NOT NULL")
    @ResultMap("growthRecordCollectMap")
    List<GrowthRecordCollect> parGrowthRecordCollectList();

    /**
     * 教师点赞list
     * @return
     */
    @Select("select * from growth_record_collect WHERE tea_no is NOT NULL")
    @ResultMap("growthRecordCollectMap")
    List<GrowthRecordCollect> teaGrowthRecordCollectList();

    /*==========================老师点赞相关=======================*/

    /**
     * 老师点赞信息添加
     * @param growthRecordCollect 成长记录点赞
     * @return
     */
    @Insert("insert into growth_record_collect (par_id,tea_no,growth_record_id,collect_state,remark) " +
            "values (null,#{teacher.teaNo},#{growthRecord.growthRecordId},1,null)")
    Integer teaGRCollect(GrowthRecordCollect growthRecordCollect);

    /**
     * 修改老师点赞状态
     * @param growthRecordCollect
     * @return
     */
    @Update("update growth_record_collect set collect_state=#{collectState} " +
            "where tea_no=#{teacher.teaNo} and growth_record_id=#{growthRecord.growthRecordId}")
    Integer updateTeaGRState(GrowthRecordCollect growthRecordCollect);

    /**
     * 根据教师工号查找点赞记录
     * @param teaNo 教师工号
     * @return
     */
    @Select("select * from growth_record_collect " +
            "where tea_no=#{teaNo}")
    @ResultMap("growthRecordCollectMap")
    List<GrowthRecordCollect> teaGRCollectList(@Param("teaNo") String teaNo);

    /*==========================家长点赞相关=======================*/

    /**
     * 家长点赞信息添加
     * @param growthRecordCollect
     * @return
     */
    @Insert("insert into growth_record_collect (par_id,tea_no,growth_record_id,collect_state,remark) " +
            "values (#{parents.parId},null,#{growthRecord.growthRecordId},1,null)")
    Integer parGRCollect(GrowthRecordCollect growthRecordCollect);

    /**
     * 修改家长点赞状态
     * @param growthRecordCollect
     * @return
     */
    @Update("update growth_record_collect set collect_state=#{collectState} " +
            "where par_id=#{parents.parId} and growth_record_id=#{growthRecord.growthRecordId}")
    Integer updateParGRState(GrowthRecordCollect growthRecordCollect);

    /**
     * 根据家长id查找点赞记录
     * @param parId 家长id
     * @return
     */
    @Select("select * from growth_record_collect " +
            "where par_id=#{parId} and collect_state=1")
    @ResultMap("growthRecordCollectMap")
    List<GrowthRecordCollect> parGRCollectList(@Param("parId") Integer parId);
}
