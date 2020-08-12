package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.CampusDynamicCollect;
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
    public Integer teaCollect(CampusDynamicCollect campusDynamicCollect) {
        return campusDynamicCollectMapper.teaCollect(campusDynamicCollect);
    }

    @Override
    public Integer updateTeaState(String teaNo, Integer campusDynamicId, Integer collectState) {
        return campusDynamicCollectMapper.updateTeaState(teaNo,campusDynamicId,collectState);
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
    public Integer updateParState(Integer parId, Integer campusDynamicId, Integer collectState) {
        return campusDynamicCollectMapper.updateParState(parId, campusDynamicId, collectState);
    }

    @Override
    public List<CampusDynamicCollect> parCollectList(Integer parId) {
        return campusDynamicCollectMapper.parCollectList(parId);
    }
}
