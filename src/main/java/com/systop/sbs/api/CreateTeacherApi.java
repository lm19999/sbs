package com.systop.sbs.api;

import com.systop.sbs.common.pojo.CreateClass;
import com.systop.sbs.common.pojo.Teacher;
import com.systop.sbs.common.util.QRCodeUtil;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.CreateClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Random;
import java.util.UUID;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/5 16:08
 **/
@RestController
@CrossOrigin
@RequestMapping("/api")
public class CreateTeacherApi {

    @Autowired
    CreateClassService createClassService;

    @RequestMapping("/selectAllCreateClassService")
    public SbsResult selectAllCreateClassService(@RequestParam("teaNo") String teaNo){
        if (createClassService.selectCreateTeacherByTeaNo(teaNo).size() == 0){
            return SbsResult.fail("500","没有数据");
        }else{
            return SbsResult.success(createClassService.selectCreateTeacherByTeaNo(teaNo));
        }
    }


    /**
     * 创建群聊方法
     * 获取前台传递的老师工号，自动生成班级号以及班级二维码
     * 用随机函数生成班级号
     * 将班级号写入二维码，自动生成二维码
     *
     * 参数一     二维码包含的内容，文本或网址
     * 参数二     生成的二维码图片存放位置
     * 参数三     生成的二维码图片尺寸 可以自定义或者默认（250）
     * 参数四     logo的存放位置
     * */

    @RequestMapping("/insertCreateClass")
    public SbsResult insertCreateClass(@RequestParam("teaNo") String teaNo,
            @RequestParam("className") String className, @RequestParam("file") MultipartFile multipartFile){
        CreateClass createClass = new CreateClass();
        int START = 10000; // 定义范围开始数字
        int END = 20000; // 定义范围结束数字
        Random random = new Random();
//        随机生成班级号
        String number =String.valueOf (random.nextInt(END - START + 1) + START);
//        根据班级号生成二维码
        String code = QRCodeUtil.zxingCodeCreate(number,"D:/picture/",null,null);

        Teacher teacher = new Teacher();
        teacher.setTeaNo(teaNo);
//        赋值
        createClass.setClassNum(number);
        createClass.setClassName(className);
        createClass.setClassCode(code);
        createClass.setTeacher(teacher);
        createClass.setClassSize(200);
        createClass.setRemark("");

        Integer result = createClassService.insertCreateClass(createClass);
        if (result == 0){
            return SbsResult.fail("500","没有数据");
        }else {
            return SbsResult.success(result);
        }
    }

}
