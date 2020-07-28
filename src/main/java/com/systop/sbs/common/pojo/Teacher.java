package com.systop.sbs.common.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 教师pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/27 15:57
 **/
@Data
public class Teacher {
    //教师工号
    private String teaNo;
    //教师姓名
    private String teaName;
    //教师密码
    private String teaPwd;
    //教师在线状态：0在线 1离线
    private Integer teaOnlineStatus;
    //教师类型：0管理员1普通教师
    private Integer teaType;
    //备注
    private String remark;
}
