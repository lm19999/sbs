package com.systop.sbs.service;

import com.systop.sbs.common.pojo.InitiationUrl;
import org.springframework.web.multipart.MultipartFile;

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

//    查询所有的启蒙链接数据，根据启蒙类型
    List<InitiationUrl> selectInitiationUrlByType(Integer initiationUrlType);

    //    添加启蒙链接数据
    Integer insertInitiationUrl(InitiationUrl initiationUrl);

    //    删除启蒙链接
    Integer deleteInitiationUrl(Integer initiationUrlId);

//    按类型id删除启蒙连接数据
    Integer deleteInitiationUrlByType(Integer initiationUrlType);
}
