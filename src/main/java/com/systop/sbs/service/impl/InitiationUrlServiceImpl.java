package com.systop.sbs.service.impl;

import com.systop.sbs.common.pojo.Initiation;
import com.systop.sbs.common.pojo.InitiationUrl;
import com.systop.sbs.common.pojo.Student;
import com.systop.sbs.mapper.InitiationUrlMapper;
import com.systop.sbs.service.InitiationService;
import com.systop.sbs.service.InitiationUrlService;
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
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/3 10:47
 **/

@Service
public class InitiationUrlServiceImpl implements InitiationUrlService {
    @Autowired
    InitiationUrlMapper initiationUrlMapper;

    @Override
    public InitiationUrl selectInitiationUrlById(Integer initiationUrlId) {
        return initiationUrlMapper.selectInitiationUrlById(initiationUrlId);
    }

    @Override
    public List<InitiationUrl> selectAllInitiationUrl() {
        return initiationUrlMapper.selectAllInitiationUrl();
    }

    @Override
    public Integer insertInitiationUrl(InitiationUrl initiationUrl) {
        return initiationUrlMapper.insertInitiationUrl(initiationUrl);
    }

    @Override
    public Integer deleteInitiationUrl(Integer initiationUrlId) {
        return initiationUrlMapper.deleteInitiationUrl(initiationUrlId);
    }

//    批量添加启蒙数据
//    @Override
//    public Integer batchImport(MultipartFile file) throws Exception {
//        int count = 0;
//        List<InitiationUrl> initiationUrlList = new ArrayList<>();
//        Workbook wb = null;
//        String fileName = file.getOriginalFilename();
//        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
//        //把文件转换为输入流
//        InputStream inputStream = file.getInputStream();
//        //判断是否是xlsx后缀
//        if (suffix.equals("xlsx")){
//            wb = new XSSFWorkbook(inputStream);
//        }else {
//            wb = new HSSFWorkbook(inputStream);
//        }
//        //获得第一张sheet表
//        Sheet sheet = wb.getSheetAt(0);
//        if (sheet != null){
//
//            //遍历数据，从表单的第二行开始
//            for (int line=1;line<=sheet.getLastRowNum();line++){
//                InitiationUrl initiationUrl = new InitiationUrl();//行数据对象
//                Row row =sheet.getRow(line);//读行
//                //规避空行
//                if (row == null){
//                    continue;
//                }
//                //读取整行信息
//                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//                String initUrl = row.getCell(0).getStringCellValue();
//
//                initiationUrl.setInitiationUrl(initUrl);
//
//                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//                String initiationLrc = row.getCell(1).getStringCellValue();
//                initiationUrl.setInitiationLrc(initiationLrc);
//
//                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
//                String initiationUrlName = row.getCell(2).getStringCellValue();
//                initiationUrl.setInitiationUrlName(initiationUrlName);
//
//                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
//                String initiationUrlTitle = row.getCell(3).getStringCellValue();
//                initiationUrl.setInitiationUrlTitle(initiationUrlTitle);
//
//                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
//                String initiationUrlDescribe = row.getCell(4).getStringCellValue();
//                initiationUrl.setInitiationUrlDescribe(initiationUrlDescribe);
//
//                if (row.getCell(5) != null){
//                    row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
//                    String remark = row.getCell(5).getStringCellValue();
//                    initiationUrl.setRemark(remark);
//                }else {
//                    initiationUrl.setRemark("");
//                }
//                System.out.println(initiationUrl);
//                initiationUrlList.add(initiationUrl);
//
//            }
//
//            for (InitiationUrl initiationUrl : initiationUrlList){
//                int i = initiationUrlMapper.insertInitiationUrl(initiationUrl);
//                count = count+i;
//            }
//
//        }
//        return count;
//    }
}
