package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.Banner;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BannerMapper {
    //查询所有的banner
    @Select("select * from banner")
    List<Banner> selectAllBanner();

//    查询所有已经发布的banner信息
    @Select("select * from banner where banner_status = 1")
    List<Banner> selectAllBannerByStatus();

//    删除banner
    @Delete("delete from banner where banner_id=#{bannerId}")
    Integer deleteBanner(Integer bannerId);

//    添加banner
    @Insert("insert into banner (banner_url,link_url,banner_status,remark) values(#{bannerUrl},#{linkUrl},#{bannerStatus},#{remark})")
    Integer insertBanner(Banner banner);

//    更新banner状态
    @Update("update banner set banner_status = #{bannerStatus} where banner_id = #{bannerId}")
    Integer updateBanner(Integer bannerId,Integer bannerStatus);
}
