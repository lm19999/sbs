package com.systop.sbs.service;

import com.systop.sbs.common.pojo.Banner;

public interface BannerService {
//    查询所有的banner信息
    Banner selectAllBanner();

//    删除banner信息
    Integer deleteBanner(Integer bannerId);

//    添加banner信息
    Integer insertBanner(Banner banner);
}
