package com.systop.sbs.service;

import com.systop.sbs.common.pojo.GrowthRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO 成长记录的service
 * @Author: 贾小翠
 * @Date: 2020/7/30 15:44
 **/
public interface GrowthRecordService {

    /**
     * 查询所有成长记录信息
     * @return list
     */
    List<GrowthRecord> searchGrowthRecordList();


    /**
     * 删除成长记录信息
     * @param growthRecordId 成长记录Id
     * @return
     */
    Integer deleteGrowthRecord(@Param("growthRecordId") Integer growthRecordId);

    /**
     * 添加成长记录信息
     * @param campusDynamic 成长记录
     * @return
     */
    Integer addGrowthRecord(GrowthRecord growthRecord);

    /**
     * 修改成长记录信息
     * @param growthRecord 成长记录
     * @return
     */
    Integer updateGrowthRecord(GrowthRecord growthRecord);

    /**
     * 根据id查询成长记录信息
     * @param growthRecordId 成长记录Id
     * @return
     */
    GrowthRecord searchGrowthRecordById(@Param("growthRecordId") Integer growthRecordId);
}
