package com.systop.sbs.service;

import com.systop.sbs.common.pojo.Initiation;
import com.systop.sbs.common.pojo.InitiationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/29 20:58
 **/

public interface InitiationTypeService {
//    查询所有的启蒙类型
    List<InitiationType> selectAll();
//    按id查询启蒙数据
    InitiationType selectById(Integer initiationTypeId);
//    增加启蒙类型
    Integer insertInitiationType(InitiationType initiationType);
//    更改启蒙类型数据
    Integer updateInitiationType(InitiationType initiationType);
//    删除启蒙类型数据
    Integer deleteInitiationType(Integer initiationTypeId);
}
