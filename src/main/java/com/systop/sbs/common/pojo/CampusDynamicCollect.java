package com.systop.sbs.common.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 校园动态点赞pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:55
 **/
@Data
public class CampusDynamicCollect {
    //校园动态点赞id
    private Integer campus_dynamic_collect_id;
    //家长id
    private Parents parents;
    //老师id
    private Teacher teacher;
    //校园动态id
    private CampusDynamic campusDynamic;
    //备注
    private String remark;
}
