package com.systop.sbs.service;

import com.systop.sbs.common.pojo.Teacher;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/29 16:12
 **/
public interface AdminService {
    //    管理员登录
    Teacher adminlogin(String username, String password);
}
