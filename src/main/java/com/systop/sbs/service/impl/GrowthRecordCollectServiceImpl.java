package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.GrowthRecordCollect;
import com.systop.sbs.mapper.GrowthRecordCollectMapper;
import com.systop.sbs.service.GrowthRecordCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/4 9:58
 **/
@Service
public class GrowthRecordCollectServiceImpl implements GrowthRecordCollectService {

    @Autowired
    private GrowthRecordCollectMapper growthRecordCollectMapper;

    @Override
    public List<GrowthRecordCollect> growthRecordCollectList() {
        return growthRecordCollectMapper.growthRecordCollectList();
    }

    @Override
    public List<GrowthRecordCollect> parGrowthRecordCollectList() {
        return growthRecordCollectMapper.parGrowthRecordCollectList();
    }

    @Override
    public List<GrowthRecordCollect> teaGrowthRecordCollectList() {
        return growthRecordCollectMapper.teaGrowthRecordCollectList();
    }

    @Override
    public Integer teaGRCollect(GrowthRecordCollect growthRecordCollect) {
        return growthRecordCollectMapper.teaGRCollect(growthRecordCollect);
    }

    @Override
    public Integer updateTeaGRState(GrowthRecordCollect growthRecordCollect) {
        return growthRecordCollectMapper.updateTeaGRState(growthRecordCollect);
    }

    @Override
    public List<GrowthRecordCollect> teaGRCollectList(String teaNo) {
        return growthRecordCollectMapper.teaGRCollectList(teaNo);
    }

    @Override
    public Integer parGRCollect(GrowthRecordCollect growthRecordCollect) {
        return growthRecordCollectMapper.parGRCollect(growthRecordCollect);
    }

    @Override
    public Integer updateParGRState(GrowthRecordCollect growthRecordCollect) {
        return growthRecordCollectMapper.updateParGRState(growthRecordCollect);
    }

    @Override
    public List<GrowthRecordCollect> parGRCollectList(Integer parId) {
        return growthRecordCollectMapper.parGRCollectList(parId);
    }
}
