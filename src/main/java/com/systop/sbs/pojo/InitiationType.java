package com.systop.sbs.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 启蒙类型pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:23
 **/
@Data
public class InitiationType {
    //启蒙类型id
    private Integer initiationTypeId;
    //启蒙类型名称
    private String initiationTypeName;
    //备注
    private String remark;
}
