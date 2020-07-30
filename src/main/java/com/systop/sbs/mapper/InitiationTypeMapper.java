package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.Initiation;
import com.systop.sbs.common.pojo.InitiationType;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/29 21:08
 **/

@Mapper
public interface InitiationTypeMapper {
    //    查询所有的启蒙类型
    @Select("select * from initiation_type")
    List<InitiationType> selectAll();
    //    按id查询启蒙数据
    @Select("select * from initiation_type where initiation_type_id = #{initiationTypeId}")
    InitiationType selectById(Integer initiationTypeId);
    //    增加启蒙类型
    @Insert("insert into initiation_type (initiation_type_name,remark) values (#{initiationTypeName},#{remark})")
    Integer insertInitiationType(InitiationType initiationType);
    //    更改启蒙类型数据
    @Update("update initiation_type set initiation_type_name = #{initiationTypeName},remark = #{remark} where initiation_type_id=#{initiationTypeId}")
    Integer updateInitiationType(InitiationType initiationType);
    //    删除启蒙类型数据
    @Delete("delete from initiation_type where initiation_type_id=#{initiationTypeId}")
    Integer deleteInitiationType(Integer initiationTypeId);
}
