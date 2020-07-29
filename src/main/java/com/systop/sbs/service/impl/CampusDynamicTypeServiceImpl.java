package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.CampusDynamicType;
import com.systop.sbs.mapper.CampusDynamicTypeMapper;
import com.systop.sbs.service.CampusDynamicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO 校园动态类型serviceImpl
 * @Author: 贾小翠
 * @Date: 2020/7/28 15:05
 **/
@Service
public class CampusDynamicTypeServiceImpl implements CampusDynamicTypeService {

    @Autowired
    private CampusDynamicTypeMapper campusDynamicTypeMapper;

    @Override
    public List<CampusDynamicType> searchCampusDynamicTypeList() {
        return campusDynamicTypeMapper.searchCampusDynamicTypeList();
    }

    @Override
    public Integer deleteCampusDynamicType(Integer campusDynamicTypeId) {
        return campusDynamicTypeMapper.deleteCampusDynamicType(campusDynamicTypeId);
    }

    @Override
    public Integer addCampusDynamicType(CampusDynamicType campusDynamicType) {
        return campusDynamicTypeMapper.addCampusDynamicType(campusDynamicType);
    }

    @Override
    public Integer updateCampusDynamicType(CampusDynamicType campusDynamicType) {
        return campusDynamicTypeMapper.updateCampusDynamicType(campusDynamicType);
    }

    @Override
    public CampusDynamicType searchCampusDynamicTypeById(Integer campusDynamicTypeId) {
        return campusDynamicTypeMapper.searchCampusDynamicTypeById(campusDynamicTypeId);
    }
}
