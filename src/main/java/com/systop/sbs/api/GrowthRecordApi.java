package com.systop.sbs.api;

import com.systop.sbs.common.pojo.GrowthRecord;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.GrowthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
