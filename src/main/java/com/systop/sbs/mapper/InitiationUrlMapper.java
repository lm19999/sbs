package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.InitiationUrl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/3 10:44
 **/
@Mapper
public interface InitiationUrlMapper {
//    查询所有启蒙数据链接
    @Select("select * from initiation_url")
    List<InitiationUrl> selectAllInitiationUrl();

//按id查询启蒙链接数据
    @Select("select * from initiation_url where initiation_url_id=#{initiationUrlId}")
    InitiationUrl selectInitiationUrlById(Integer initiationUrlId);

//    添加启蒙链接数据
    @Insert("insert into initiation_url (initiation_url,initiation_url_name,initiation_url_title,initiation_url_describe,remark)" +
            " values(#{initiationUrl},#{initiationUrlName},#{initiationUrlTitle},#{initiationUrlDescribe},#{remark})")
    Integer insertInitiationUrl(InitiationUrl initiationUrl);

//    删除启蒙链接
    @Delete("delete from initiation_url where initiation_url_id = #{initiationUrlId}")
    Integer deleteInitiationUrl(Integer initiationUrlId);
}
