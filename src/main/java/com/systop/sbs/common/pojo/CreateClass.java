package com.systop.sbs.common.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 创建班级表pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:08
 **/
@Data
public class CreateClass {
    //班级名称
    private String className;
    //班级二维码
    private String classCode;
    //班级号
    private String classNum;
    //教师工号
    private Teacher teacher;
    //群最大人数
    private Integer classSize;
    //备注
    private String remark;
}
