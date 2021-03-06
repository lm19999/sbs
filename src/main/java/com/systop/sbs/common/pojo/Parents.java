package com.systop.sbs.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 家长pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/27 16:01
 **/
@Data
@JsonIgnoreProperties(value = {"handler"})
public class Parents {
    //家长id
    private Integer parId;
    //家长姓名
    private String parName;
    //家长密码
    private String parPwd;
    //家长电话
    private String parPhone;
    //家长头像
    private String parPortrait;
    //学生学号
    private Student student;
    //家长在线状态：0在线 1离线
    private Integer parOnlineStatus;
    //备注
    private String remark;
}
