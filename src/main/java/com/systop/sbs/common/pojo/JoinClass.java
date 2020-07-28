package com.systop.sbs.common.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: TODO 加入班级pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:13
 **/
@Data
public class JoinClass {
    //班级id
    private CreateClass createClass;
    //家长id
    private Parents parents;
    //备注
    private String remark;
}
