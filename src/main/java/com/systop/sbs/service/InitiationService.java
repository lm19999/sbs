package com.systop.sbs.service;

import com.systop.sbs.common.pojo.Initiation;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/30 11:20
 **/
public interface InitiationService {
//    查询所有的启蒙数据
    List<Initiation> selectAllInitiation();
//    按启蒙类型查询数据
    List<Initiation> selectAllInitiationByType(Integer initiationTypeId);
//    添加启蒙数据
    Integer insertInitiation(Initiation initiation);
//    删除启蒙数据
    Integer deleteInitiation(Integer initiationId);
}
