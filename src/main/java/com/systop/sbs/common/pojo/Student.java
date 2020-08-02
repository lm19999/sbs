package com.systop.sbs.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Program: sbs
 * @Description: TODO 学生pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/27 15:50
 **/
@Data
@JsonIgnoreProperties(value = {"handler"})
public class Student {
    //学生学号
    private String stuNo;
    //学生姓名
    private String stuName;
    //学生性别
    private String stuSex;
    //所属班级
    private String stuClass;
    //出生日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date stuBirth;
    //籍贯
    private String stuAddress;
    //备注
    private String remark;
}
