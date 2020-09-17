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
 * @Date: 2020/8/3 16:31
 **/
@Mapper
public interface CampusDynamicCollectMapper {
    /*============================list===========================*/

    /**
     * 查询所有点赞
     * @return
     */
    @Select("select cdc.*,par.*,tea.*,cd.* from campus_dynamic_collect cdc " +
            "LEFT JOIN parents par ON cdc.par_id=par.par_id " +
            "LEFT JOIN teacher tea ON cdc.tea_no=tea.tea_no " +
            "LEFT JOIN campus_dynamic cd ON cdc.campus_dynamic_id=cd.campus_dynamic_id")
    @Results(id = "campusDynamicCollectMap",value = {
            @Result(id = true, column = "campus_dynamic_collect_id", property = "campusDynamicCollectId"),
            @Result(column = "collect_state", property = "collectState"),
            @Result(column = "remark", property = "remark"),
            @Result(property = "parents", column = "par_id",
                    one = @One(select = "com.systop.sbs.mapper.ParentsMapper.searchParentsById",
                            fetchType = FetchType.LAZY)),
            @Result(property = "teacher", column = "tea_no",
                    one = @One(select = "com.systop.sbs.mapper.TeacherMapper.searchTeacherByTno",
                            fetchType = FetchType.LAZY)),
            @Result(property = "campusDynamic", column = "campus_dynamic_id",
                    one = @One(select = "com.systop.sbs.mapper.CampusDynamicMapper.searchCampusDynamicById",
                            fetchType = FetchType.LAZY))
        }
    )
    List<CampusDynamicCollect> campusDynamicCollectList();

    /**
     * 查询所有点赞
     * @return
     */
    @Select("select cdc.*,par.*,tea.*,cd.* from campus_dynamic_collect cdc " +
            "LEFT JOIN parents par ON cdc.par_id=par.par_id " +
            "LEFT JOIN teacher tea ON cdc.tea_no=tea.tea_no " +
            "LEFT JOIN campus_dynamic cd ON cdc.campus_dynamic_id=cd.campus_dynamic_id " +
            "WHERE cdc.campus_dynamic_id=#{campusDynamicId}")
    @ResultMap("campusDynamicCollectMap")
    List<CampusDynamicCollect> campusDynamicCollectListByCampus(@Param("campusDynamicId") Integer campusDynamicId);

    /**
     * 家长点赞list
     * @return
     */
    @Select("select * from campus_dynamic_collect WHERE par_id is NOT NULL")
    @ResultMap("campusDynamicCollectMap")
    List<GrowthRecordCollect> parCampusCollectList();

    /**
     * 教师点赞list
     * @return
     */
    @Select("select * from campus_dynamic_collect WHERE tea_no is NOT NULL")
    @ResultMap("campusDynamicCollectMap")
    List<GrowthRecordCollect> teaCampusCollectList();
    /*==========================老师点赞相关=======================*/

    /**
     * 老师点赞信息添加
     * @param campusDynamicCollect
     * @return
     */
    @Insert("insert into campus_dynamic_collect (par_id,tea_no,campus_dynamic_id,collect_state,remark) " +
            "values (null,#{teacher.teaNo},#{campusDynamic.campusDynamicId},1,null)")
    Integer teaCollect(CampusDynamicCollect campusDynamicCollect);

    /**
     * 修改老师点赞状态
     * @param campusDynamicCollect
     * @return
     */
    @Update("update campus_dynamic_collect set collect_state=#{collectState} " +
            "where tea_no=#{teacher.teaNo} and campus_dynamic_id=#{campusDynamic.campusDynamicId}")
    Integer updateTeaState(CampusDynamicCollect campusDynamicCollect);

    /**
     * 根据教师工号查找点赞记录
     * @param teaNo 教师工号
     * @return
     */
    @Select("select * from campus_dynamic_collect " +
            "where tea_no=#{teaNo}")
    List<CampusDynamicCollect> teaCollectList(@Param("teaNo") String teaNo);

    /*==========================家长点赞相关=======================*/

    /**
     * 家长点赞信息添加
     * @param campusDynamicCollect
     * @return
     */
    @Insert("insert into campus_dynamic_collect (par_id,tea_no,campus_dynamic_id,collect_state,remark) " +
            "values (#{parents.parId},null,#{campusDynamic.campusDynamicId},1,null)")
    Integer parCollect(CampusDynamicCollect campusDynamicCollect);

    /**
     * 修改家长点赞状态
     * @param campusDynamicCollect
     * @return
     */
    @Update("update campus_dynamic_collect set collect_state=#{collectState} " +
            "where par_id=#{parents.parId} and campus_dynamic_id=#{campusDynamic.campusDynamicId}")
    Integer updateParState(CampusDynamicCollect campusDynamicCollect);

    /**
     * 根据家长id查找点赞记录
     * @param parId 家长id
     * @return
     */
    @Select("select * from campus_dynamic_collect " +
            "where par_id=#{parId}")
    List<CampusDynamicCollect> parCollectList(@Param("parId") Integer parId);
}
