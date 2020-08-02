package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.CampusDynamic;
import com.systop.sbs.mapper.CampusDynamicMapper;
import com.systop.sbs.service.CampusDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO 校园动态的ServiceImpl
 * @Author: 贾小翠
 * @Date: 2020/7/29 12:27
 **/
@Service
@Transactional
public class CampusDynamicServiceImpl implements CampusDynamicService {

    @Autowired
    private CampusDynamicMapper campusDynamicMapper;

    @Override
    public List<CampusDynamic> searchCampusDynamicList() {
        return campusDynamicMapper.searchCampusDynamicList();
    }

    @Override
    public List<CampusDynamic> officialNewsList() {
        return campusDynamicMapper.officialNewsList();
    }

    @Override
    public List<CampusDynamic> activityList() {
        return campusDynamicMapper.activityList();
    }

    @Override
    public Integer deleteCampusDynamic(Integer campusDynamicId) {
        return campusDynamicMapper.deleteCampusDynamic(campusDynamicId);
    }

    @Override
    public Integer addCampusDynamic(CampusDynamic campusDynamic) {
        return campusDynamicMapper.addCampusDynamic(campusDynamic);
    }

    @Override
    public Integer updateCampusDynamic(CampusDynamic campusDynamic) {
        return campusDynamicMapper.updateCampusDynamic(campusDynamic);
    }

    @Override
    public Integer updateStatus(Integer campusDynamicId, Integer campusDynamicStatus) {
        return campusDynamicMapper.updateStatus(campusDynamicId,campusDynamicStatus);
    }

    @Override
    public CampusDynamic searchCampusDynamicById(Integer campusDynamicId) {
        return campusDynamicMapper.searchCampusDynamicById(campusDynamicId);
    }
}
