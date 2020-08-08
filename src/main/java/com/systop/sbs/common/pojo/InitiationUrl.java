package com.systop.sbs.common.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/3 10:30
 **/
@Data
public class InitiationUrl {
    //读物链接id
    private Integer initiationUrlId;
    //读物链接
    private String initiationUrl;
    //儿歌lrc歌词文件
    private String initiationLrc;
    //读物名称
    private String initiationUrlName;
    //读物标题
    private String initiationUrlTitle;
    //读物描述
    private String initiationUrlDescribe;
    //备注
    private String remark;
}
