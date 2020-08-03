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
    //读物图片
    private String initiationImg;
    //读物链接id
    private InitiationUrl initiationUrl;
    //发布状态：0未发布,1已发布
    private Integer initiationStatus;
    //备注
    private String remark;
}
