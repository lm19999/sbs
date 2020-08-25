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

    //按类型查询启蒙数据
    @Select("select * from initiation where initiation_type_id=#{initiationTypeId}")
    @Results({
            @Result(property = "initiationType", column = "initiation_type_id",
                    one = @One(select = "com.systop.sbs.mapper.InitiationTypeMapper.selectById")),
            @Result(property = "initiationUrl", column = "initiation_url_id",
                    one = @One(select = "com.systop.sbs.mapper.InitiationUrlMapper.selectInitiationUrlById"))
    })
    List<Initiation> selectInitiationByType(Integer initiationTypeId);

//    按外键id查询启蒙数据
    @Select("select * from initiation where initiation_url_id = #{initiationUrlId}")
    Initiation selectInitiationByUrlId(Integer initiationUrlId);

    //添加启蒙数据
    @Insert("insert into initiation (initiation_type_id,initiation_img,initiation_url_id,initiation_status,remark)" +
            " values(#{initiationType.initiationTypeId},#{initiationImg},#{initiationUrl.initiationUrlId},#{initiationStatus},#{remark})")
    Integer insertInitiation(Initiation initiation);

    //    删除启蒙数据
    @Delete("delete from initiation where initiation_id=#{initiationId}")
    Integer deleteInitiation(Integer initiationId);

    //    更新启蒙数据状态，实现一键发布取消发布
    @Update("update initiation set initiation_status = #{1} where initiation_id = #{0}")
    Integer updateInitiationByStatus(Integer initiationId,Integer initiationStatus);

//    根据启蒙类型，删除启蒙数据
    @Delete("delete from initiation where initiation_type_id = #{initiationTypeId}")
    Integer deleteInitiationByType(Integer initiationTypeId);

//    根据启蒙链接外键id，删除启蒙数据
    @Delete("delete from initiation where initiation_url_id = #{initiationUrlId}")
    Integer deleteInitiationByUrlId(Integer initiationUrlId);
}
