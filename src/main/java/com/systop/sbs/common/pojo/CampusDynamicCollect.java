package com.systop.sbs.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 校园动态点赞pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:55
 **/
@Data
@JsonIgnoreProperties(value = {"handler"})
public class CampusDynamicCollect {
    //校园动态点赞id
    private Integer campusDynamicCollectId;
    //家长id
    private Parents parents;
    //老师id
    private Teacher teacher;
    //校园动态id
    private CampusDynamic campusDynamic;
    //点赞状态（0：未点赞，1：点赞）
    private Integer collectState;
    //备注
    private String remark;
}
