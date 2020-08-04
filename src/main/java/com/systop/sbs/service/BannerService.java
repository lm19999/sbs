package com.systop.sbs.service;

import com.systop.sbs.common.pojo.Banner;

import java.util.List;

public interface BannerService {
//    查询所有的banner信息
    List<Banner> selectAllBanner();

//    查询所有已经发布的banner信息
    List<Banner> selectAllBannerByStatus();

//    删除banner信息
    Integer deleteBanner(Integer bannerId);

//    添加banner信息
    Integer insertBanner(Banner banner);

    //    更新banner状态
    Integer updateBanner(Integer bannerId,Integer bannerStatus);
}
