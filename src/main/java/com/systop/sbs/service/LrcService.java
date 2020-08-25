package com.systop.sbs.service;

import com.systop.sbs.common.pojo.Lrc;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/10 8:30
 **/
public interface LrcService {
    //    查询所有歌词文件
    List<Lrc> selectAllLrc();
    //    按id查询歌词文件
    Lrc selectLrcById(Integer lrcId);

    //    添加歌词文件
    Integer insertLrc(Lrc lrc);

    //    删除歌词文件
    Integer deleteLrc(Integer id);
}
