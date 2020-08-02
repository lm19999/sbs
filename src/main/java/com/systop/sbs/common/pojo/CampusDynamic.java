package com.systop.sbs.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 校园动态pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 9:50
 **/
@Data
@JsonIgnoreProperties(value = {"handler"})
public class CampusDynamic {
    //校园动态id
    private Integer campusDynamicId;
    //动态类型id
    private CampusDynamicType campusDynamicType;
    //标题
    private String campusDynamicName;
    //图片（视频）地址
    private String campusDynamicUrl;
    //文字描述
    private String campusDynamicDescribe;
    //浏览量
    private Integer campusDynamicViews;
    //发布状态：0未发布 1已发布
    private Integer campusDynamicStatus;
    //备注
    private String remark;
}
