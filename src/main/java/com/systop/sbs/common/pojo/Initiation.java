package com.systop.sbs.common.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 启蒙pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:28
 **/
@Data
public class Initiation {
    //启蒙id
    private Integer initiationId;
    //启蒙类型id
    private InitiationType initiationType;
    //读物标题
    private String initiationTitle;
    //读物名称
    private String initiationName;
    //读物连接
    private String initiationUrl;
    //读物描述
    private String initiationDescribe;
    //发布状态：0未发布,1已发布
    private Integer initiationStatus;
    //备注
    private String remark;
}
