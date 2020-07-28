package com.systop.sbs.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 成长记录pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:16
 **/
@Data
public class GrowthRecord {
    //成长记录id
    private Integer growthRecordId;
    //家长id
    private Parents parents;
    //位置信息
    private String growthRecordPosition;
    //动态链接
    private String growthRecordUrl;
    //文字描述
    private String growthRecordDescribe;
    //浏览量，默认为0
    private Integer growthRecordViews;
    //备注
    private String remark;
}
