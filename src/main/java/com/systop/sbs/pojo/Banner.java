package com.systop.sbs.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 轮播实体类
 * @Author: 贾小翠
 * @Date: 2020/7/27 16:05
 **/
@Data
public class Banner {
    //id
    private Integer bannerId;
    //图片地址
    private String bannerUrl;
    //链接地址
    private String linkUrl;
    //发布状态：0：未发布 1：已发布
    private Integer bannerStatus;
    //备注
    private String remark;
}
