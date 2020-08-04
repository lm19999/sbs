package com.systop.sbs.service;

import com.systop.sbs.common.pojo.InitiationUrl;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/3 10:46
 **/
public interface InitiationUrlService {
//按id查询启蒙链接数据
    InitiationUrl selectInitiationUrlById(Integer initiationUrlId);

    //    查询所有启蒙数据链接
    List<InitiationUrl> selectAllInitiationUrl();

    //    添加启蒙链接数据
    Integer insertInitiationUrl(InitiationUrl initiationUrl);

    //    删除启蒙链接
    Integer deleteInitiationUrl(Integer initiationUrlId);
}
