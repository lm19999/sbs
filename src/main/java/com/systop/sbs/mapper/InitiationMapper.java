package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.Initiation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/30 11:05
 **/
@Mapper
public interface InitiationMapper {
//    查询所有的启蒙数据
@Select("select * from initiation")
@Results({
        @Result(property = "initiationType", column = "initiation_type_id",
                one = @One(select = "com.systop.sbs.mapper.InitiationTypeMapper.selectById")),
        @Result(property = "initiationUrl", column = "initiation_url_id",
                one = @One(select = "com.systop.sbs.mapper.InitiationUrlMapper.selectInitiationUrlById"))
})
    List<Initiation> selectAllInitiation();

//按类型查询启蒙数据
@Select("select * from initiation where initiation_type_id=#{initiationTypeId} and initiation_status = 1")
@Results({
        @Result(property = "initiationType", column = "initiation_type_id",
                one = @One(select = "com.systop.sbs.mapper.InitiationTypeMapper.selectById")),
        @Result(property = "initiationUrl", column = "initiation_url_id",
                one = @One(select = "com.systop.sbs.mapper.InitiationUrlMapper.selectInitiationUrlById"))
})
    List<Initiation> selectAllInitiationByType(Integer initiationTypeId);

//添加启蒙数据
    @Insert("insert into initiation (initiation_type_id,initiation_img,initiation_url_id,initiation_status,remark)" +
            " values(#{initiationType.initiationTypeId},#{initiationImg},#{initiationUrl.initiationUrlId},#{initiationStatus},#{remark})")
    Integer insertInitiation(Initiation initiation);

//    删除启蒙数据
    @Delete("delete from initiation where initiation_id=#{initiationId}")
    Integer deleteInitiation(Integer initiationId);
}
