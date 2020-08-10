package com.systop.sbs.api;

import com.systop.sbs.common.pojo.GrowthRecord;
import com.systop.sbs.common.pojo.Parents;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.common.util.UploadImage;
import com.systop.sbs.common.util.UploadMore;
import com.systop.sbs.service.GrowthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/5 16:34
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/growthRecord")
public class GrowthRecordApi {
    @Autowired
    public GrowthRecordService growthRecordService;

    /**
     * 查询所有成长记录信息
     * @return list
     */
    @GetMapping("/growthRecordList")
    public SbsResult growthRecordList(){
        if (growthRecordService.searchGrowthRecordList().size() == 0){
            return SbsResult.fail("300","暂无数据");
        } else {
            return SbsResult.success(growthRecordService.searchGrowthRecordList());
        }
    }

    /**
     * 根据家长查询成长记录
     * @return list
     */
    @PostMapping("/findGrowthRecordByPar")
    public SbsResult growthRecordListByPar(@RequestParam("parId") Integer parId){
        if (growthRecordService.growthRecordListByPar(parId).size() == 0){
            return SbsResult.fail("300","暂无数据");
        } else {
            return SbsResult.success(growthRecordService.growthRecordListByPar(parId));
        }
    }

    /**
     * 家长删除
     * @param growthRecordId
     * @return
     */
    @PostMapping("/delGrowthRecord")
    public SbsResult delGrowthRecord(@RequestParam("growthRecordId") Integer growthRecordId,
                                     @RequestParam("parId") Integer parId){
        GrowthRecord growthRecord = growthRecordService.searchGrowthRecordById(growthRecordId);
        if (parId == growthRecord.getGrowthRecordId()){
            return SbsResult.success(growthRecordService.deleteGrowthRecord(growthRecordId));
        } else {
            return SbsResult.fail("300","您没有删除此记录的权限！");
        }
    }

    /**
     * 家长添加成长记录
     * @param parId 家长id
     * @param growthRecordPosition 位置信息
     * @param growthRecordUrl   文件
     * @param growthRecordDescribe  描述
     * @return
     * @RequestParam("parId") Integer parId,
     *                                      @RequestParam("growthRecordPosition") String growthRecordPosition,
     *                                      @RequestParam("growthRecordUrl") List<MultipartFile> growthRecordUrl,
     *                                      @RequestParam("growthRecordDescribe") String growthRecordDescribe
     */
    @PostMapping(value = "/addGrowthRecord",produces = "application/json;charset=UTF-8")
    public SbsResult addGrowthRecord(@RequestParam("parId") Integer parId,
                                     @RequestParam("growthRecordPosition") String growthRecordPosition,
                                     @RequestParam("growthRecordUrl") MultipartFile[] growthRecordUrl,
                                     @RequestParam("growthRecordDescribe") String growthRecordDescribe){
        GrowthRecord growthRecord = new GrowthRecord();
        Parents parents = new Parents();
        parents.setParId(parId);
        growthRecord.setParents(parents);
        growthRecord.setGrowthRecordPosition(growthRecordPosition);
//        growthRecord.setGrowthRecordUrl(UploadImage.uploadImages(growthRecordUrl));
        growthRecord.setGrowthRecordDescribe(growthRecordDescribe);
        String url = "";
        if (growthRecordUrl != null && growthRecordUrl.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < growthRecordUrl.length; i++) {
                MultipartFile file = growthRecordUrl[i];
                url += UploadMore.uploadFile(file)+"&";
            }
        }
        growthRecord.setGrowthRecordUrl(url);
        System.out.println(url);
        return SbsResult.success(growthRecordService.addGrowthRecord(growthRecord));
    }
}
