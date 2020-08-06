package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.Parents;
import com.systop.sbs.mapper.ParentsMapper;
import com.systop.sbs.service.ParentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO   parents的ServiceImpl
 * @Author: 贾小翠  张莉
 * @Date: 2020/7/29 14:35
 **/
@Service
public class ParentsServiceImpl implements ParentsService {

    @Autowired
    private ParentsMapper parentsMapper;

    @Override
    public Integer registerParents(Parents parents) {
        return parentsMapper.registerParents(parents);
    }

    @Override
    public Parents parentsLogin(String parPhone, String parPwd) {
        return parentsMapper.parentsLogin(parPhone, parPwd);
    }

    @Override
    public Integer forgetParentsPwd(String parPwd, String parPhone) {
        return parentsMapper.forgetParentsPwd(parPwd, parPhone);
    }

    @Override
    public Integer parentsLogout(Parents parents) {
        return parentsMapper.parentsLogout(parents);
    }

    @Override
    public List<Parents> searchParentsList() {
        return parentsMapper.searchParentsList();
    }

    @Override
    public Integer deleteParents(Integer parId) {
        return parentsMapper.deleteParents(parId);
    }

    @Override
    public Integer addParents(Parents parents) {
        return parentsMapper.addParents(parents);
    }

    @Override
    public Integer updateParents(Parents parents) {
        return parentsMapper.updateParents(parents);
    }

    @Override
    public Parents searchParentsById(Integer parId) {
        return parentsMapper.searchParentsById(parId);
    }

    @Override
    public Integer parentsChangeName(Parents parents) {
        return parentsMapper.parentsChangeName(parents);
    }

    @Override
    public Integer parentsChangePhone(Parents parents) {
        return parentsMapper.parentsChangePhone(parents);
    }

    @Override
    public Integer parentsChangeTx(Parents parents) {
        return parentsMapper.parentsChangeTx(parents);
    }

    @Override
    public Integer parentsLoginStatus(Parents parents) {
        return parentsMapper.parentsLoginStatus(parents);
    }

    @Override
    public Integer parentsLogoutStatus(Parents parents) {
        return parentsMapper.parentsLogoutStatus(parents);
    }
}
