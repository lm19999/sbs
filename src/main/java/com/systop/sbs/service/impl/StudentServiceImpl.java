package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.Student;
import com.systop.sbs.mapper.StudentMapper;
import com.systop.sbs.service.StudentService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Program: com.systop.sbs.service.impl
 * @Description: TODO
 * @Author: ZhangLi
 * @Date: 2020/7/29 16:21
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> allStu() {
        return studentMapper.allStu();
    }

    @Override
    public Student stuBySno(String sno) {
        return studentMapper.stuBySno(sno);
    }

    @Override
    public Integer addStu(Student student) {
        return studentMapper.addStu(student);
    }

    @Override
    public Integer updateStu(Student student) {
        return studentMapper.updateStu(student);
    }

    @Override
    public Integer delStu(String stuNo) {
        return studentMapper.delStu(stuNo);
    }

    @Override
    public Integer batchImport(MultipartFile file) throws Exception {
        int count = 0;
        List<Student> studentList = new ArrayList<>();
        Workbook wb = null;
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
        //把文件转换为输入流
        InputStream inputStream = file.getInputStream();
        //判断是否是xlsx后缀
        if (suffix.equals("xlsx")){
            wb = new XSSFWorkbook(inputStream);
        }else {
            wb = new HSSFWorkbook(inputStream);
        }
        //获得第一张sheet表
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null){

            //遍历数据，从表单的第二行开始
            for (int line=1;line<=sheet.getLastRowNum();line++){
                Student student = new Student();//行数据对象
                Row row =sheet.getRow(line);//读行
                //规避空行
                if (row == null){
                    continue;
                }
                //读取整行信息
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                String stuNo = row.getCell(0).getStringCellValue();
                if (stuNo==null || stuNo.isEmpty()){
                    throw new IOException("导入失败，第"+(line+1)+"行，学号未填写");
                }
                student.setStuNo(stuNo);

                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                String stuName = row.getCell(1).getStringCellValue();
                student.setStuName(stuName);

                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                String stuSex = row.getCell(2).getStringCellValue();
                student.setStuSex(stuSex);

                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                String stuClass = row.getCell(3).getStringCellValue();
                student.setStuClass(stuClass);

                row.getCell(4).setCellType(Cell.CELL_TYPE_NUMERIC);
                Date stuBirth = row.getCell(4).getDateCellValue();
                student.setStuBirth(stuBirth);

                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                String stuAddress = row.getCell(5).getStringCellValue();
                student.setStuAddress(stuAddress);

                if (row.getCell(6) != null){
                    row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                    String remark = row.getCell(6).getStringCellValue();
                    student.setRemark(remark);
                }else {
                    row.createCell(6).setCellValue(new XSSFRichTextString(String.valueOf(row.getCell(6))));
                }

                studentList.add(student);

            }

            for (Student student : studentList){
                int i = studentMapper.addStu(student);
                count = count+i;
            }

        }
        return count;
    }
}
