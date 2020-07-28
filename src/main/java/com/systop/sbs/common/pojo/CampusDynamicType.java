package com.systop.sbs.common.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 校园动态类型pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:02
 **/
@Data
public class CampusDynamicType {
    //校园动态类型id
    private Integer campusDynamicTypeId;
    //校园动态类型名称
    private String campusDynamicTypeName;
    //备注
    private String remark;
}
