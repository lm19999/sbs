package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.JoinClass;
import com.systop.sbs.mapper.JoinClassMapper;
import com.systop.sbs.service.JoinClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/6 16:42
 **/
@Service
public class JoinClassServiceImpl implements JoinClassService {
    @Autowired
    JoinClassMapper joinClassMapper;

    @Override
    public Integer joinClass(JoinClass joinClass) {
        return joinClassMapper.joinClass(joinClass);
    }
}
