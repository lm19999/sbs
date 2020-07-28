package com.systop.sbs.service;

import com.systop.sbs.common.pojo.CampusDynamicType;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/7/28 15:03
 **/
public interface CampusDynamicTypeService {
    /**
     * 查询所有校园动态类型信息
     * @return list
     */
    List<CampusDynamicType> searchCampusDynamicTypeList();

    /**
     * 删除校园动态类型信息
     * @param campusDynamicTypeId 校园动态类型Id
     * @return
     */
    Integer deleteCampusDynamicType(@Param("campusDynamicTypeId") Integer campusDynamicTypeId);

    /**
     * 添加校园动态类型信息
     * @param campusDynamicType 校园动态类型
     * @return
     */
    Integer addCampusDynamicType(CampusDynamicType campusDynamicType);

    /**
     * 修改校园动态类型信息
     * @param campusDynamicType 校园动态类型
     * @return
     */
    Integer updateCampusDynamicType(CampusDynamicType campusDynamicType);


    /**
     * 根据id查询校园动态类型信息
     * @param campusDynamicTypeId 校园动态类型Id
     * @return
     */
    CampusDynamicType searchCampusDynamicTypeById(@Param("campusDynamicTypeId") Integer campusDynamicTypeId);
}
