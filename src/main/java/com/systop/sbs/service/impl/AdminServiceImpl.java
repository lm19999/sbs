package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.Teacher;
import com.systop.sbs.mapper.AdminMapper;
import com.systop.sbs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/29 16:12
 **/

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Teacher adminlogin(String username, String password) {
        return adminMapper.adminlogin(username,password);
    }
}
