package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.CampusDynamic;
import org.apache.ibatis.annotations.*;

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
    @Select("select * from campus_dynamic")
    List<CampusDynamic> searchCampusDynamicList();

    /**
     * 删除校园动态信息
     * @param campusDynamicId 校园动态Id
     * @return
     */
    @Delete("delete from campus_dynamic_type where campus_dynamic_type_id=#{campusDynamicTypeId}")
    Integer deleteCampusDynamic(@Param("campusDynamicId") Integer campusDynamicId);

    /**
     * 添加校园动态信息
     * @param campusDynamic 校园动态
     * @return
     */
    @Insert("insert into campus_dynamic (campus_dynamic_type_name,remark) " +
            "values (#{campusDynamicTypeName},#{remark})")
    Integer addCampusDynamic(CampusDynamic campusDynamic);

    /**
     * 修改校园动态信息
     * @param campusDynamic 校园动态
     * @return
     */
    @Update("update campus_dynamic_type set campus_dynamic_type_name=#{campusDynamicTypeName},remark=#{remark} " +
            "WHERE campus_dynamic_type_id=#{campusDynamicTypeId}")
    Integer updateCampusDynamic(CampusDynamic campusDynamic);


    /**
     * 根据id查询校园动态信息
     * @param campusDynamicId 校园动态Id
     * @return
     */
    @Select("select * from campus_dynamic where campus_dynamic_id = #{campusDynamicId}")
    CampusDynamic searchCampusDynamicById(@Param("campusDynamicId") Integer campusDynamicId);
}
