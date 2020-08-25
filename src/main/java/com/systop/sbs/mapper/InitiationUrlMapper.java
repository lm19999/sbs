package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.InitiationUrl;
import org.apache.ibatis.annotations.*;

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
@Select("select * from initiation_url left join lrc on initiation_url.initiation_lrc=lrc.lrc_id")
@Results({
        @Result(property = "lrc", column = "lrc_id",
                one = @One(select = "com.systop.sbs.mapper.LrcMapper.selectLrcById"))
})
    List<InitiationUrl> selectAllInitiationUrl();

//查询所有的启蒙链接数据，按照启蒙类型
@Select("select * from initiation_url where initiation_url_type = #{initiationUrlType}")
    List<InitiationUrl> selectInitiationUrlByType(Integer initiationUrlType);

//left join lrc on initiation_url.initiation_lrc=lrc.lrc_id and
//按id查询启蒙链接数据有儿歌数据
    @Select("select * from initiation_url,lrc where initiation_url.initiation_lrc=lrc.lrc_id and initiation_url_id = #{initiationUrlId}")
    @Results({
            @Result(property = "lrc", column = "lrc_id",
                    one = @One(select = "com.systop.sbs.mapper.LrcMapper.selectLrcById")),
    })
    InitiationUrl selectInitiationUrlById(Integer initiationUrlId);

    //按id查询启蒙链接数据没有儿歌歌词数据
    @Select("select * from initiation_url where initiation_url_id = #{initiationUrlId}")
    InitiationUrl selectInitiationUrlByIdNo(Integer initiationUrlId);


//    添加启蒙链接数据
    @Insert("insert into initiation_url (initiation_url_type,initiation_url,initiation_lrc,initiation_url_name,initiation_url_title,initiation_url_describe,remark)" +
            " values(#{initiationUrlType},#{initiationUrl},#{lrc.lrcId},#{initiationUrlName},#{initiationUrlTitle},#{initiationUrlDescribe},#{remark})")
    Integer insertInitiationUrl(InitiationUrl initiationUrl);

//    删除启蒙链接
    @Delete("delete from initiation_url where initiation_url_id = #{initiationUrlId}")
    Integer deleteInitiationUrl(Integer initiationUrlId);

//    按照类型id删除启蒙连接数据
    @Delete("delete from initiation_url where initiation_url_type = #{initiationUrlType}")
    Integer deleteInitiationUrlByType(Integer initiationUrlType);
}
