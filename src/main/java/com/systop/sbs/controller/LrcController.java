package com.systop.sbs.controller;

import com.systop.sbs.common.pojo.Lrc;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.common.util.Upload;
import com.systop.sbs.service.LrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/10 8:33
 **/
@RestController
@RequestMapping("/lrc")
public class LrcController {

    @Autowired
    LrcService lrcService;

    /**
     * 查询所有歌词文件方法
     * @Return  List
     * */
    @RequestMapping("/selectAllLrc")
    public SbsResult selectAllLrc(){
        return SbsResult.success(lrcService.selectAllLrc());
    }


    @RequestMapping("/insertLrc")
    public SbsResult insertLrc(@RequestParam("lrcName") String lrcName, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
        Lrc lrc = new Lrc();
        lrc.setLrcUrl("");
        if (multipartFile != null) {
            Upload upload = new Upload();
            lrc.setLrcUrl(upload.upload(multipartFile, request));
        }
        lrc.setLrcName(lrcName);
        return SbsResult.success(lrcService.insertLrc(lrc));
    }


    @RequestMapping("/deleteLrc")
    public SbsResult deleteLrc(@RequestParam("lrcId") Integer lrcId){
        return SbsResult.success(lrcService.deleteLrc(lrcId));
    }

}
