package com.systop.sbs.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 成长记录点赞pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:32
 **/
@Data
@JsonIgnoreProperties(value = {"handler"})
public class GrowthRecordCollect {
    //成长记录点赞id
    private Integer growthRecordCollectId;
    //家长id
    private Parents parents;
    //老师id
    private Teacher teacher;
    //成长记录id
    private GrowthRecord growthRecord;
    //点赞状态（0：未点赞，1：点赞）
    private Integer collectState;
    //备注
    private String remark;
}
