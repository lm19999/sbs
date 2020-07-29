package com.systop.sbs.service.impl;

import com.systop.sbs.mapper.BannerMapper;
import com.systop.sbs.common.pojo.Banner;
import com.systop.sbs.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<Banner> selectAllBanner() {
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

    @Override
    public Integer updateBanner(Integer bannerId, Integer bannerStatus) {
        return bannerMapper.updateBanner(bannerId,bannerStatus);
    }
}
