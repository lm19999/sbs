package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.GrowthRecord;
import com.systop.sbs.mapper.GrowthRecordMapper;
import com.systop.sbs.service.GrowthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO 成长记录的serviceImpl
 * @Author: 贾小翠
 * @Date: 2020/7/30 15:46
 **/
@Service
public class GrowthRecordServiceImpl implements GrowthRecordService {

    @Autowired
    private GrowthRecordMapper growthRecordMapper;

    @Override
    public List<GrowthRecord> searchGrowthRecordList() {
        return growthRecordMapper.searchGrowthRecordList();
    }

    @Override
    public List<GrowthRecord> growthRecordListByPar(Integer parId) {
        return growthRecordMapper.growthRecordListByPar(parId);
    }

    @Override
    public Integer deleteGrowthRecord(Integer growthRecordId) {
        return growthRecordMapper.deleteGrowthRecord(growthRecordId);
    }

    @Override
    public Integer addGrowthRecord(GrowthRecord growthRecord) {
        return growthRecordMapper.addGrowthRecord(growthRecord);
    }

    @Override
    public Integer updateGrowthRecord(GrowthRecord growthRecord) {
        return growthRecordMapper.updateGrowthRecord(growthRecord);
    }

    @Override
    public GrowthRecord searchGrowthRecordById(Integer growthRecordId) {
        return growthRecordMapper.searchGrowthRecordById(growthRecordId);
    }

    @Override
    public int updateGrowthRecordCollects(int growthRecordId, int growthRecordCollects) {
        return growthRecordMapper.updateGrowthRecordCollects(growthRecordId,growthRecordCollects);
    }
}
