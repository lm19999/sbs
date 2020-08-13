package com.systop.sbs.api;

import com.systop.sbs.common.pojo.GrowthRecord;
import com.systop.sbs.common.pojo.GrowthRecordCollect;
import com.systop.sbs.common.pojo.Parents;
import com.systop.sbs.common.pojo.Teacher;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.common.util.UploadImage;
import com.systop.sbs.common.util.UploadMore;
import com.systop.sbs.service.GrowthRecordCollectService;
import com.systop.sbs.service.GrowthRecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    @Autowired
    public GrowthRecordCollectService growthRecordCollectService;

    /**
     * 查询所有成长记录信息
     * @return list
     */
    @GetMapping("/growthRecordTeaList")
    public SbsResult growthRecordTeaList(){
        Map map = new HashMap();
        List<GrowthRecord> growthRecordList = growthRecordService.searchGrowthRecordList();
        List<GrowthRecordCollect> growthRecordCollectList = growthRecordCollectService.teaGrowthRecordCollectList();
        if (growthRecordList.size() == 0){
            return SbsResult.fail("300","暂无数据");
        } else {
            map.put("growthRecordList",growthRecordList);
            map.put("growthRecordCollectList",growthRecordCollectList);
            return SbsResult.success(map);
        }
    }

    /**
     * 查询所有成长记录信息
     * @return list
     */
    @GetMapping("/growthRecordParList")
    public SbsResult growthRecordParList(){
        Map map = new HashMap();
        List<GrowthRecord> growthRecordList = growthRecordService.searchGrowthRecordList();
        List<GrowthRecordCollect> growthRecordCollectList = growthRecordCollectService.parGrowthRecordCollectList();
        if (growthRecordList.size() == 0){
            return SbsResult.fail("300","暂无数据");
        } else {
            map.put("growthRecordList",growthRecordList);
            map.put("growthRecordCollectList",growthRecordCollectList);
            return SbsResult.success(map);
        }
    }

    /**
     * 根据家长查询成长记录
     * @return list
     */
    @PostMapping("/findGrowthRecordByPar")
    public SbsResult growthRecordListByPar(@RequestParam("parId") Integer parId){
        Map map = new HashMap();
        List<GrowthRecord> growthRecordList = growthRecordService.growthRecordListByPar(parId);
        List<GrowthRecordCollect> growthRecordCollectList = growthRecordCollectService.growthRecordCollectList();
        if (growthRecordList.size() == 0){
            return SbsResult.fail("300","暂无数据");
        } else {
            map.put("growthRecordList",growthRecordList);
            map.put("growthRecordCollectList",growthRecordCollectList);
            return SbsResult.success(map);
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
                                     @RequestParam("growthRecordDescribe") String growthRecordDescribe,
                                     HttpServletRequest request){
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
                url += UploadMore.uploadFile(file,request)+"&";
            }
        }
        growthRecord.setGrowthRecordUrl(url);
        System.out.println(url);
        return SbsResult.success(growthRecordService.addGrowthRecord(growthRecord));
    }

    /**
     * 根据id查询成长记录信息
     * @param growthRecordId 成长记录Id
     * @return
     */
    @PostMapping("/searchGrowthRecordById")
    public SbsResult searchGrowthRecordById(@RequestParam("growthRecordId") Integer growthRecordId){
        return SbsResult.success(growthRecordService.searchGrowthRecordById(growthRecordId));
    }


    /*======================================教师点赞====================================*/

    /**
     * 查询所有成长记录家长点赞
     * @return
     */
    @GetMapping("/teaGrowthCollectList")
    public SbsResult teaGrowthCollectList(){
        return SbsResult.success(growthRecordCollectService.teaGrowthRecordCollectList());
    }

    /**
     * 根据教师工号查询教师点赞记录
     * @param teaNo
     * @return
     */
    @RequestMapping("/teaGRCollectList")
    public SbsResult teaGRCollectList(@Param("teaNo") String teaNo){
        return SbsResult.success(growthRecordCollectService.teaGRCollectList(teaNo));
    }

    /**
     * 教师点赞信息添加
     * @param teaNo
     * @param growthRecordId
     * @return
     */
    @PostMapping("/teaGrowthCollect")
    public SbsResult teaGrowthCollect(@RequestParam("teaNo") String teaNo,
                                      @RequestParam("growthRecordId") Integer growthRecordId){
        Teacher teacher = new Teacher();
        GrowthRecord growthRecord = new GrowthRecord();
        GrowthRecordCollect growthRecordCollect = new GrowthRecordCollect();
        teacher.setTeaNo(teaNo);
        growthRecord.setGrowthRecordId(growthRecordId);
        growthRecordCollect.setTeacher(teacher);
        growthRecordCollect.setGrowthRecord(growthRecord);
        return SbsResult.success(growthRecordCollectService.teaGRCollect(growthRecordCollect));
    }

    /**
     * 修改
     * @param teaNo
     * @param growthRecordId
     * @param collectState
     * @return
     */
    @PostMapping("/updateTeaGRState")
    public SbsResult updateTeaGRState(@RequestParam("teaNo") String teaNo,
                             @RequestParam("growthRecordId") Integer growthRecordId,
                             @RequestParam("collectState") Integer collectState){
        Teacher teacher = new Teacher();
        GrowthRecord growthRecord = new GrowthRecord();
        GrowthRecordCollect growthRecordCollect = new GrowthRecordCollect();
        teacher.setTeaNo(teaNo);
        growthRecord.setGrowthRecordId(growthRecordId);
        growthRecordCollect.setTeacher(teacher);
        growthRecordCollect.setGrowthRecord(growthRecord);
        growthRecordCollect.setCollectState(collectState);
        return SbsResult.success(growthRecordCollectService.updateTeaGRState(growthRecordCollect));
    }

    /*======================================家长点赞====================================*/
    /**
     * 查询所有成长记录家长点赞
     * @return
     */
    @GetMapping("/parGrowthCollectList")
    public SbsResult parGrowthCollectList(){
        return SbsResult.success(growthRecordCollectService.parGrowthRecordCollectList());
    }

    /**
     * 根据家长id查询家长点赞
     * @param parId 家长id
     * @return
     */
    @PostMapping("/parGRCollectList")
    public SbsResult parGRCollectList(@Param("parId") Integer parId){
        return SbsResult.success(growthRecordCollectService.parGRCollectList(parId));
    }

    /**
     * 家长点赞信息添加
     * @param parId
     * @param growthRecordId
     * @return
     */
    @PostMapping("/parGrowthCollect")
    public SbsResult parGrowthCollect(@RequestParam("parId") Integer parId,
                                      @RequestParam("growthRecordId") Integer growthRecordId){
        Parents parents = new Parents();
        GrowthRecord growthRecord = new GrowthRecord();
        GrowthRecordCollect growthRecordCollect = new GrowthRecordCollect();
        parents.setParId(parId);
        growthRecord.setGrowthRecordId(growthRecordId);
        growthRecordCollect.setParents(parents);
        growthRecordCollect.setGrowthRecord(growthRecord);
        return SbsResult.success(growthRecordCollectService.parGRCollect(growthRecordCollect));
    }

    @PostMapping("/updateParGRState")
    public SbsResult updateParGRState(@RequestParam("parId") Integer parId,
                                      @RequestParam("growthRecordId") Integer growthRecordId,
                                      @RequestParam("collectState") Integer collectState){
        Parents parents = new Parents();
        GrowthRecord growthRecord = new GrowthRecord();
        GrowthRecordCollect growthRecordCollect = new GrowthRecordCollect();
        parents.setParId(parId);
        growthRecord.setGrowthRecordId(growthRecordId);
        growthRecordCollect.setParents(parents);
        growthRecordCollect.setGrowthRecord(growthRecord);
        growthRecordCollect.setCollectState(collectState);
        return SbsResult.success(growthRecordCollectService.updateParGRState(growthRecordCollect));
    }

    /**
     * 修改点赞人数
     * @param growthRecordId
     * @return
     */
    @PostMapping("/addGrowthRecordCollects")
    public SbsResult addGrowthRecordCollects(@RequestParam("growthRecordId") int growthRecordId){
        GrowthRecord growthRecord = growthRecordService.searchGrowthRecordById(growthRecordId);
        Integer num = growthRecord.getGrowthRecordCollects();
        Integer growthRecordCollects = num+1;
        return SbsResult.success(growthRecordService.updateGrowthRecordCollects(growthRecordId,growthRecordCollects));
    }

    /**
     * 修改点赞人数
     * @param growthRecordId
     * @return
     */
    @PostMapping("/updateGrowthRecordCollects")
    public SbsResult updateGrowthRecordCollects(@RequestParam("growthRecordId") int growthRecordId){
        GrowthRecord growthRecord = growthRecordService.searchGrowthRecordById(growthRecordId);
        Integer num = growthRecord.getGrowthRecordCollects();
        Integer growthRecordCollects = num-1;
        return SbsResult.success(growthRecordService.updateGrowthRecordCollects(growthRecordId,growthRecordCollects));
    }
}
