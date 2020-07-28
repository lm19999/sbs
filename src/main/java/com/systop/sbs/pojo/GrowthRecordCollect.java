package com.systop.sbs.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 成长记录点赞pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:32
 **/
@Data
public class GrowthRecordCollect {
    //成长记录点赞id
    private Integer growthRecordCollectId;
    //家长id
    private Parents parents;
    //老师id
    private Teacher teacher;
    //成长记录id
    private GrowthRecord growthRecord;
    //备注
    private String remark;
}
