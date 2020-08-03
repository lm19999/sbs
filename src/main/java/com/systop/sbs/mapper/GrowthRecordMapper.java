package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.GrowthRecord;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO 成长记录的mapper
 * @Author: 贾小翠
 * @Date: 2020/7/30 10:44
 **/
@Mapper
public interface GrowthRecordMapper {

    /**
     * 查询所有成长记录信息
     * @return list
     */
    @Select("select gr.*,par.* from growth_record gr " +
            "INNER JOIN parents par ON gr.growth_record_par_id=par.par_id " +
            "ORDER BY cd.growth_record_id desc")
    @Results(id = "growthRecordMap",value = {
            @Result(id = true,column = "growth_record_id",property = "growthRecordId"),
            @Result(column = "growth_record_position",property = "growthRecordPosition"),
            @Result(column = "growth_record_url",property = "growthRecordUrl"),
            @Result(column = "growth_record_describe",property = "growthRecordDescribe"),
            @Result(column = "growth_record_collects",property = "growthRecordCollects"),
            @Result(column = "growth_record_views",property = "growthRecordViews"),
            @Result(column = "remark",property = "remark"),
            @Result(property = "parents",column = "growth_record_par_id",
                    one = @One(select = "com.systop.sbs.mapper.ParentsMapper.searchParentsById",
                            fetchType = FetchType.LAZY)),
    })
    List<GrowthRecord> searchGrowthRecordList();


    /**
     * 删除成长记录信息
     * @param growthRecordId 成长记录Id
     * @return
     */
    @Delete("delete from growth_record where growth_record_id=#{growthRecordId}")
    Integer deleteGrowthRecord(@Param("growthRecordId") Integer growthRecordId);

    /**
     * 添加成长记录信息
     * @param growthRecord 成长记录
     * @return
     */
    @Insert("insert into growth_record (growth_record_par_id,growth_record_position,growth_record_url," +
            "growth_record_describe,growth_record_collects,growth_record_views,remark) " +
            "values (#{parents.parId},#{growthRecordPosition},#{growthRecordUrl}," +
            "#{growthRecordDescribe},0,0,#{null})")
    Integer addGrowthRecord(GrowthRecord growthRecord);

    /**
     * 修改成长记录信息
     * @param growthRecord 成长记录
     * @return
     */
    @Update("update campus_dynamic set growth_record_par_id=#{parents.parId}," +
            "growth_record_position=#{growthRecordPosition},growth_record_url=#{growthRecordUrl}," +
            "growth_record_describe=#{growthRecordDescribe},growth_record_views=#{growthRecordViews},remark=#{remark} " +
            "WHERE growth_record_id=#{growthRecordId}")
    Integer updateGrowthRecord(GrowthRecord growthRecord);

    /**
     * 根据id查询成长记录信息
     * @param growthRecordId 成长记录Id
     * @return
     */
    @Select("select * from campus_dynamic where growth_record_id = #{growthRecordId}")
    @ResultMap("growthRecordMap")
    GrowthRecord searchGrowthRecordById(@Param("growthRecordId") Integer growthRecordId);
}
