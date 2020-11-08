package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.Initiation;
import com.systop.sbs.mapper.InitiationMapper;
import com.systop.sbs.service.InitiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/30 11:22
 **/

@Service
public class InitiationServiceImpl implements InitiationService {

    @Autowired
    InitiationMapper initiationMapper;

    @Override
    public List<Initiation> selectAllInitiation() {
        return initiationMapper.selectAllInitiation();
    }

    @Override
    public List<Initiation> selectAllInitiationByType(Integer initiationTypeId) {
        return initiationMapper.selectAllInitiationByType(initiationTypeId);
    }

    @Override
    public List<Initiation> selectInitiationByType(Integer initiationTypeId) {
        return initiationMapper.selectInitiationByType(initiationTypeId);
    }

    @Override
    public Initiation selectInitiationByUrlId(Integer initiationUrlId) {
        return initiationMapper.selectInitiationByUrlId(initiationUrlId);
    }

    @Override
    public List<Initiation> selectInitiationByTypeAndName(Integer initiationTypeId,String initiationUrlName) {
        return initiationMapper.selectInitiationByTypeAndName(initiationTypeId,initiationUrlName);
    }

    @Override
    public Integer insertInitiation(Initiation initiation) {
        return initiationMapper.insertInitiation(initiation);
    }

    @Override
    public Integer deleteInitiation(Integer initiationId) {
        return initiationMapper.deleteInitiation(initiationId);
    }

    @Override
    public Integer updateInitiationByStatus(Integer initiationId, Integer initiationStatus) {
        return initiationMapper.updateInitiationByStatus(initiationId,initiationStatus);
    }

    @Override
    public Integer deleteInitiationByType(Integer initiationTypeId) {
        return initiationMapper.deleteInitiationByType(initiationTypeId);
    }

    @Override
    public Integer deleteInitiationByUrlId(Integer initiationUrlId) {
        return initiationMapper.deleteInitiationByUrlId(initiationUrlId);
    }
}
