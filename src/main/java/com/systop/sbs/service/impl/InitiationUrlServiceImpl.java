package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.InitiationUrl;
import com.systop.sbs.mapper.InitiationUrlMapper;
import com.systop.sbs.service.InitiationService;
import com.systop.sbs.service.InitiationUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/3 10:47
 **/

@Service
public class InitiationUrlServiceImpl implements InitiationUrlService {
    @Autowired
    InitiationUrlMapper initiationUrlMapper;

    @Override
    public InitiationUrl selectInitiationUrlById(Integer initiationUrlId) {
        return initiationUrlMapper.selectInitiationUrlById(initiationUrlId);
    }

    @Override
    public List<InitiationUrl> selectAllInitiationUrl() {
        return initiationUrlMapper.selectAllInitiationUrl();
    }

    @Override
    public Integer insertInitiationUrl(InitiationUrl initiationUrl) {
        return initiationUrlMapper.insertInitiationUrl(initiationUrl);
    }

    @Override
    public Integer deleteInitiationUrl(Integer initiationUrlId) {
        return initiationUrlMapper.deleteInitiationUrl(initiationUrlId);
    }
}
