package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.Student;
import com.systop.sbs.common.util.ExcelUtil;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.StudentService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Program: com.systop.sbs.controller
 * @Description: TODO
 * @Author: ZhangLi
 * @Date: 2020/7/29 16:23
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查看所有学生信息
     * @return
     */
    @RequestMapping("/findAllStudent")
    public SbsResult findAllStudent(){
        return SbsResult.success(studentService.allStu());
    }

    /**
     * 根据学号查找学生
     * @param stuNo 学号
     * @return
     */
    @RequestMapping("/stuBySno")
    public SbsResult findStuBySno(@RequestParam("stuNo") String stuNo){
        return SbsResult.success(studentService.stuBySno(stuNo));
    }

    /**
     * 添加学生信息
     * @param stuNo   学号
     * @param stuName 姓名
     * @param stuSex  性别
     * @param stuClass 所属班级
     * @param stuBirth 出生日期
     * @param stuAddress 籍贯
     * @param remark 备注
     * @return
     */
    @RequestMapping("/addStudent")
    public SbsResult addStudent(@RequestParam("stuNo") String stuNo, @RequestParam("stuName") String stuName,
                                @RequestParam("stuSex") String stuSex, @RequestParam("stuClass") String stuClass,
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("stuBirth") Date stuBirth,
                                @RequestParam("stuAddress") String stuAddress,
                                @RequestParam("remark") String remark){
        Student student = new Student();
        student.setStuNo(stuNo);
        student.setStuName(stuName);
        student.setStuSex(stuSex);
        student.setStuClass(stuClass);
        student.setStuBirth(stuBirth);
        student.setStuAddress(stuAddress);
        student.setRemark(remark);
        return SbsResult.success(studentService.addStu(student));
    }

    /**
     * 修改学生信息
     * @param stuNo   学号
     * @param stuName 姓名
     * @param stuSex  性别
     * @param stuClass 所属班级
     * @param stuBirth 出生日期
     * @param stuAddress 籍贯
     * @param remark 备注
     * @return
     */
    @RequestMapping("/updateStu")
    public SbsResult updateStu(@RequestParam("stuNo") String stuNo, @RequestParam("stuName") String stuName,
                               @RequestParam("stuSex") String stuSex, @RequestParam("stuClass") String stuClass,
                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("stuBirth") Date stuBirth,
                               @RequestParam("stuAddress") String stuAddress,
                               @RequestParam("remark") String remark){
        Student student = new Student();
        student.setStuNo(stuNo);
        student.setStuName(stuName);
        student.setStuSex(stuSex);
        student.setStuClass(stuClass);
        student.setStuBirth(stuBirth);
        student.setStuAddress(stuAddress);
        student.setRemark(remark);
        return SbsResult.success(studentService.updateStu(student));
    }

    /**
     * 删除学生信息
     * @param stuNo 学号
     * @return
     */
    @RequestMapping("/delStu")
    public SbsResult delStu(@RequestParam("stuNo") String stuNo){
        return SbsResult.success(studentService.delStu(stuNo));
    }

    /**
     * 批量上传学生信息
     * @param file 文件
     * @return
     * @throws Exception
     */
    @RequestMapping("/batchImport")
    public SbsResult batchImport(MultipartFile file) throws Exception{
        int count = studentService.batchImport(file);
        return SbsResult.success(count);
    }

    /**
     *导出学生信息excel
     * @throws Exception
     */
    @RequestMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取数据
        List<Student> list = studentService.allStu();
        //excel表头
        String[] title = {"学号","姓名","性别","所属班级","出生日期","家庭住址","备注"};
        //文件名
        String fileName = "学生信息表.xls";
        //sheet名
        String sheetName = "学生信息表";

        String [][] content = new String[list.size()][];
        for (int i=0;i<list.size();i++){
            content[i] = new String[title.length];
            Student obj = list.get(i);
            content[i][0] = obj.getStuNo();
            content[i][1] = obj.getStuName();
            content[i][2] = obj.getStuSex();
            content[i][3] = obj.getStuClass();
            content[i][4] = sdf.format(obj.getStuBirth());
            content[i][5] = obj.getStuAddress();
            content[i][6] = obj.getRemark();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName,title,content,null);
        //相应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName){
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
