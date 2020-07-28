package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.CampusDynamicType;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO 校园动态类型mapper
 * @Author: 贾小翠
 * @Date: 2020/7/28 14:41
 **/
@Mapper
public interface CampusDynamicTypeMapper {
    /**
     * 查询所有校园动态类型信息
     * @return list
     */
    @Select("select * from campus_dynamic_type")
    List<CampusDynamicType> searchCampusDynamicTypeList();

    /**
     * 删除校园动态类型信息
     * @param campusDynamicTypeId 校园动态类型Id
     * @return
     */
    @Delete("delete from campus_dynamic_type where campus_dynamic_type_id=#{campusDynamicTypeId}")
    Integer deleteCampusDynamicType(@Param("campusDynamicTypeId") Integer campusDynamicTypeId);

    /**
     * 添加校园动态类型信息
     * @param campusDynamicType 校园动态类型
     * @return
     */
    @Insert("insert into campus_dynamic_type (campus_dynamic_type_name,remark) " +
            "values (#{campusDynamicTypeName},#{remark})")
    Integer addCampusDynamicType(CampusDynamicType campusDynamicType);

    /**
     * 修改校园动态类型信息
     * @param campusDynamicType 校园动态类型
     * @return
     */
    @Update("update campus_dynamic_type set campus_dynamic_type_name=#{campusDynamicTypeName},remark=#{remark} " +
            "WHERE campus_dynamic_type_id=#{campusDynamicTypeId}")
    Integer updateCampusDynamicType(CampusDynamicType campusDynamicType);


    /**
     * 根据id查询校园动态类型信息
     * @param campusDynamicTypeId 校园动态类型Id
     * @return
     */
    @Select("select * from campus_dynamic_type where campus_dynamic_type_id = #{campusDynamicTypeId}")
    CampusDynamicType searchCampusDynamicTypeById(@Param("campusDynamicTypeId") Integer campusDynamicTypeId);
}
