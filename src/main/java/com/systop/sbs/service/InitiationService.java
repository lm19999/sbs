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
//    按启蒙类型查询数据含发布状态
    List<Initiation> selectAllInitiationByType(Integer initiationTypeId);
//    按启蒙类型查询数据不含发布状态
    List<Initiation> selectInitiationByType(Integer initiationTypeId);
//    按启蒙链接外键id查询启蒙数据
    Initiation selectInitiationByUrlId(Integer initiationUrlId);
//    按输入名称和类型查询所有的启蒙数据
    List<Initiation> selectInitiationByTypeAndName(Integer initiationTypeId,String initiationUrlName);
//    添加启蒙数据
    Integer insertInitiation(Initiation initiation);
//    删除启蒙数据
    Integer deleteInitiation(Integer initiationId);
//    更新启蒙数据状态，实现一键发布取消发布
    Integer updateInitiationByStatus(Integer initiationId,Integer initiationStatus);
//    更新浏览数量
    Integer updateInitiationByBrowse(Integer initiationUrlId);
//    根据启蒙类型，删除启蒙数据
    Integer deleteInitiationByType(Integer initiationTypeId);
//    根据启蒙外键id，删除启蒙数据
    Integer deleteInitiationByUrlId(Integer initiationUrlId);

}
