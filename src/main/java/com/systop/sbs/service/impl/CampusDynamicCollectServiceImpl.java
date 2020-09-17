package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.CampusDynamicCollect;
import com.systop.sbs.common.pojo.GrowthRecordCollect;
import com.systop.sbs.mapper.CampusDynamicCollectMapper;
import com.systop.sbs.service.CampusDynamicCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/3 18:02
 **/
@Service
public class CampusDynamicCollectServiceImpl implements CampusDynamicCollectService {

    @Autowired
    private CampusDynamicCollectMapper campusDynamicCollectMapper;

    @Override
    public List<CampusDynamicCollect> campusDynamicCollectList() {
        return campusDynamicCollectMapper.campusDynamicCollectList();
    }

    @Override
    public List<CampusDynamicCollect> campusDynamicCollectListByCampus(Integer campusDynamicId) {
        return campusDynamicCollectMapper.campusDynamicCollectListByCampus(campusDynamicId);
    }

    @Override
    public List<GrowthRecordCollect> parCampusCollectList() {
        return campusDynamicCollectMapper.parCampusCollectList();
    }

    @Override
    public List<GrowthRecordCollect> teaCampusCollectList() {
        return campusDynamicCollectMapper.teaCampusCollectList();
    }

    @Override
    public Integer teaCollect(CampusDynamicCollect campusDynamicCollect) {
        return campusDynamicCollectMapper.teaCollect(campusDynamicCollect);
    }

    @Override
    public Integer updateTeaState(CampusDynamicCollect campusDynamicCollect) {
        return campusDynamicCollectMapper.updateTeaState(campusDynamicCollect);
    }

    @Override
    public List<CampusDynamicCollect> teaCollectList(String teaNo) {
        return campusDynamicCollectMapper.teaCollectList(teaNo);
    }

    @Override
    public Integer parCollect(CampusDynamicCollect campusDynamicCollect) {
        return campusDynamicCollectMapper.parCollect(campusDynamicCollect);
    }

    @Override
    public Integer updateParState(CampusDynamicCollect campusDynamicCollect) {
        return campusDynamicCollectMapper.updateParState(campusDynamicCollect);
    }

    @Override
    public List<CampusDynamicCollect> parCollectList(Integer parId) {
        return campusDynamicCollectMapper.parCollectList(parId);
    }
}
