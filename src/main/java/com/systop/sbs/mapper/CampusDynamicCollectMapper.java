package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.CampusDynamicCollect;
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
    @Select("select * from campus_dynamic_collect")
    @Results(id = "campusDynamicCollectMap",value = {
            @Result(id = true, column = "campus_dynamic_collect_id", property = "campusDynamicCollectId"),
            @Result(column = "collect_state", property = "collectState"),
            @Result(column = "remark", property = "remark"),
            @Result(property = "parents", column = "par_id",
                    one = @One(select = "com.systop.sbs.mapper.ParentsMapper.searchParentsById",
                            fetchType = FetchType.LAZY)),
            @Result(property = "teacher", column = "stu_no",
                    one = @One(select = "com.systop.sbs.mapper.TeacherMapper.searchTeacherByTno",
                            fetchType = FetchType.LAZY)),
            @Result(property = "campusDynamic", column = "campus_dynamic_id",
                    one = @One(select = "com.systop.sbs.mapper.CampusDynamicMapper.searchCampusDynamicById",
                            fetchType = FetchType.LAZY))
        }
    )
    List<CampusDynamicCollect> campusDynamicCollectList();
    /*==========================老师点赞相关=======================*/

    /**
     * 老师点赞信息添加
     * @param campusDynamicCollect
     * @return
     */
    @Insert("insert into campus_dynamic_collect (par_id,tea_no,campus_dynamic_id,collect_state,remark) " +
            "values (#{null},#{teacher.teaNo},#{campusDynamic.campusDynamicId},1,null)")
    Integer teaCollect(CampusDynamicCollect campusDynamicCollect);

    /**
     * 修改老师点赞状态
     * @param teaNo 教师工号
     * @param campusDynamicId 校园动态id
     * @param collectState 点赞状态
     * @return
     */
    @Update("update campus_dynamic_collect set collect_state=#{collectState} " +
            "where tea_no=#{teacher.teaNo} and campus_dynamic_id=#{campusDynamic.campusDynamicId}")
    Integer updateTeaState(@Param("teaNo") String teaNo,@Param("campusDynamicId") Integer campusDynamicId,
                        @Param("collectState") Integer collectState);

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
            "values (#{parents.parId},#{null},#{campusDynamic.campusDynamicId},1,#{null})")
    Integer parCollect(CampusDynamicCollect campusDynamicCollect);

    /**
     * 修改家长点赞状态
     * @param parId 家长id
     * @param campusDynamicId 校园动态id
     * @param collectState 点赞状态
     * @return
     */
    @Update("update campus_dynamic_collect set collect_state=#{collectState} " +
            "where par_id=#{parents.parId} and campus_dynamic_id=#{campusDynamic.campusDynamicId}")
    Integer updateParState(@Param("parId") Integer parId,@Param("campusDynamicId") Integer campusDynamicId,
                           @Param("collectState") Integer collectState);

    /**
     * 根据家长id查找点赞记录
     * @param parId 家长id
     * @return
     */
    @Select("select * from campus_dynamic_collect " +
            "where par_id=#{parId}")
    List<CampusDynamicCollect> parCollectList(@Param("parId") Integer parId);

}
