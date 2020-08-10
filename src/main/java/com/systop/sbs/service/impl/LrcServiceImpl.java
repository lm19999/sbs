package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.Lrc;
import com.systop.sbs.mapper.LrcMapper;
import com.systop.sbs.service.LrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/10 8:31
 **/
@Service
public class LrcServiceImpl implements LrcService {

    @Autowired
    LrcMapper lrcMapper;

    @Override
    public List<Lrc> selectAllLrc() {
        return lrcMapper.selectAllLrc();
    }

    @Override
    public Lrc selectLrcById(Integer lrcId) {
        return lrcMapper.selectLrcById(lrcId);
    }

    @Override
    public Integer insertLrc(Lrc lrc) {
        return lrcMapper.insertLrc(lrc);
    }

    @Override
    public Integer deleteLrc(Integer id) {
        return lrcMapper.deleteLrc(id);
    }
}
