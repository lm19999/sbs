package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.Initiation;
import com.systop.sbs.common.pojo.InitiationType;
import com.systop.sbs.mapper.InitiationTypeMapper;
import com.systop.sbs.service.InitiationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/29 21:20
 **/

@Service
public class InitiationTypeServiceImpl implements InitiationTypeService {

    @Autowired
    InitiationTypeMapper initiationTypeMapper;

    @Override
    public List<InitiationType> selectAll() {
        return initiationTypeMapper.selectAll();
    }

    @Override
    public InitiationType selectById(Integer initiationTypeId) {
        return initiationTypeMapper.selectById(initiationTypeId);
    }

    @Override
    public Integer insertInitiationType(InitiationType initiationType) {
        return initiationTypeMapper.insertInitiationType(initiationType);
    }

    @Override
    public Integer updateInitiationType(InitiationType initiationType) {
        return initiationTypeMapper.updateInitiationType(initiationType);
    }

    @Override
    public Integer deleteInitiationType(Integer initiationTypeId) {
        return initiationTypeMapper.deleteInitiationType(initiationTypeId);
    }
}
