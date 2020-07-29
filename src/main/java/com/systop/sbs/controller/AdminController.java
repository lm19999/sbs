package com.systop.sbs.controller;

import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/7/29 16:06
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public SbsResult login(@RequestParam("username") String username,@RequestParam("password") String password){
        if (adminService.adminlogin(username,password) == null){
            return SbsResult.fail("500","没有查询到数据");
        }else{
            return SbsResult.success(adminService.adminlogin(username,password));
        }
    }
}
