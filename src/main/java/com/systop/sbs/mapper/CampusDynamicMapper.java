package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.CampusDynamic;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO 校园动态mapper
 * @Author: 贾小翠
 * @Date: 2020/7/28 16:57
 **/
@Mapper
public interface CampusDynamicMapper {

    /**
     * 查询所有校园动态信息
     * @return list
     */
    @Select("select cd.*,cdt.* from campus_dynamic cd " +
            "INNER JOIN campus_dynamic_type cdt ON cd.campus_dynamic_type_id=cdt.campus_dynamic_type_id " +
            "ORDER BY cd.campus_dynamic_id desc")
    @Results(id = "campusDynamicMap",value = {
            @Result(id = true,column = "campus_dynamic_id",property = "campusDynamicId"),
            @Result(column = "campus_dynamic_name",property = "campusDynamicName"),
            @Result(column = "campus_dynamic_url",property = "campusDynamicUrl"),
            @Result(column = "campus_dynamic_describe",property = "campusDynamicDescribe"),
            @Result(column = "campus_dynamic_views",property = "campusDynamicViews"),
            @Result(column = "campus_dynamic_status",property = "campusDynamicStatus"),
            @Result(column = "remark",property = "remark"),
            @Result(property = "campusDynamicType",column = "campus_dynamic_type_id",
                    one = @One(select = "com.systop.sbs.mapper.CampusDynamicTypeMapper.searchCampusDynamicTypeById",
                            fetchType = FetchType.LAZY)),
    })
    List<CampusDynamic> searchCampusDynamicList();

    /**
     * 查询官方新闻
     * @return list
     */
    @Select("select cd.*,cdt.* from campus_dynamic cd " +
            "INNER JOIN campus_dynamic_type cdt ON cd.campus_dynamic_type_id=cdt.campus_dynamic_type_id " +
            "WHERE cd.campus_dynamic_type_id = 1 " +
            "ORDER BY cd.campus_dynamic_id desc")
    @ResultMap("campusDynamicMap")
    List<CampusDynamic> officialNewsList();

    /**
     * 查询活动动态
     * @return list
     */
    @Select("select cd.*,cdt.* from campus_dynamic cd " +
            "INNER JOIN campus_dynamic_type cdt ON cd.campus_dynamic_type_id=cdt.campus_dynamic_type_id " +
            "WHERE cd.campus_dynamic_type_id = 2 " +
            "ORDER BY cd.campus_dynamic_id desc")
    @ResultMap("campusDynamicMap")
    List<CampusDynamic> activityList();

    /**
     * 删除校园动态信息
     * @param campusDynamicId 校园动态Id
     * @return
     */
    @Delete("delete from campus_dynamic where campus_dynamic_id=#{campusDynamicId}")
    Integer deleteCampusDynamic(@Param("campusDynamicId") Integer campusDynamicId);

    /**
     * 添加校园动态信息
     * @param campusDynamic 校园动态
     * @return
     */
    @Insert("insert into campus_dynamic (campus_dynamic_type_id,campus_dynamic_name,campus_dynamic_url," +
            "campus_dynamic_describe,campus_dynamic_views,campus_dynamic_status,remark) " +
            "values (#{campusDynamicType.campusDynamicTypeId},#{campusDynamicName},#{campusDynamicUrl}," +
            "#{campusDynamicDescribe},#{campusDynamicViews},#{campusDynamicStatus},#{remark})")
    Integer addCampusDynamic(CampusDynamic campusDynamic);

    /**
     * 修改校园动态信息
     * @param campusDynamic 校园动态
     * @return
     */
    @Update("update campus_dynamic set campus_dynamic_type_id=#{campusDynamicType.campusDynamicTypeId}," +
            "campus_dynamic_name=#{campusDynamicName},campus_dynamic_url=#{campusDynamicUrl}," +
            "campus_dynamic_describe=#{campusDynamicDescribe},campus_dynamic_views=#{campusDynamicViews}," +
            "campus_dynamic_status=#{campusDynamicStatus},remark=#{remark} " +
            "WHERE campus_dynamic_id=#{campusDynamicId}")
    Integer updateCampusDynamic(CampusDynamic campusDynamic);

    /**
     * 修改校园动态的发布状态
     * @param campusDynamicId   校园动态Id
     * @param campusDynamicStatus 校园动态状态
     * @return
     */
    @Update("update campus_dynamic set campus_dynamic_status=#{campusDynamicStatus} " +
            "WHERE campus_dynamic_id=#{campusDynamicId}")
    Integer updateStatus(@Param("campusDynamicId") Integer campusDynamicId,@Param("campusDynamicStatus") Integer campusDynamicStatus);

    /**
     * 根据id查询校园动态信息
     * @param campusDynamicId 校园动态Id
     * @return
     */
    @Select("select * from campus_dynamic where campus_dynamic_id = #{campusDynamicId}")
    @ResultMap("campusDynamicMap")
    CampusDynamic searchCampusDynamicById(@Param("campusDynamicId") Integer campusDynamicId);
}
