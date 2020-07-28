package com.systop.sbs.mapper;

import com.systop.sbs.pojo.Banner;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BannerMapper {
    //查询所有的banner
    @Select("select * from banner")
    Banner selectAllBanner();

//    删除banner
    @Delete("delete from banner where banner_id=#{bannerId}")
    Integer deleteBanner(Integer bannerId);

//    添加banner
    @Insert("insert into banner (banner_url,banner_link,banner_status,remark) values(#{bannerUrl},#{bannerLink},#{bannerStatus},#{remark})")
    Integer insertBanner(Banner banner);
}
