package com.systop.sbs.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Program: sbs
 * @Description: TODO 创建班级表pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:08
 **/
@Data
public class CreateClass {
    //班级号
    private String classNum;
    //班级名称
    private String className;
    //班级二维码
    private String classCode;
    //班级图片
    private String classImg;
    //教师工号
    private Teacher teacher;
    //群聊创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date classTime;
    //群最大人数
    private Integer classSize;
    //备注
    private String remark;
}
