package com.systop.sbs.service.impl;

import com.systop.sbs.mapper.BannerMapper;
import com.systop.sbs.common.pojo.Banner;
import com.systop.sbs.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public Banner selectAllBanner() {
        return bannerMapper.selectAllBanner();
    }

    @Override
    public Integer deleteBanner(Integer bannerId) {
        return bannerMapper.deleteBanner(bannerId);
    }

    @Override
    public Integer insertBanner(Banner banner) {
        return bannerMapper.insertBanner(banner);
    }
}
