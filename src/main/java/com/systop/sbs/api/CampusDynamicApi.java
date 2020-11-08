package com.systop.sbs.api;

import com.systop.sbs.common.pojo.*;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.CampusDynamicCollectService;
import com.systop.sbs.service.CampusDynamicService;
import com.systop.sbs.service.CampusDynamicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: 贾小翠
 * @Date: 2020/8/4 12:31
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/campusDynamic")
public class CampusDynamicApi {
    @Autowired
    CampusDynamicService campusDynamicService;
    @Autowired
    CampusDynamicTypeService campusDynamicTypeService;
    @Autowired
    CampusDynamicCollectService campusDynamicCollectService;

    /**
     * 查询所有校园动态类型信息
     * @return SbsResult
     */
    @GetMapping("/campusDynamicTypeList")
    public SbsResult campusDynamicTypeList(){
        if (campusDynamicTypeService.searchCampusDynamicTypeList().size() == 0){
            return SbsResult.fail("500","暂无数据");
        } else {
            return SbsResult.success(campusDynamicTypeService.searchCampusDynamicTypeList());
        }
    }

    /**
     * 查询所有校园动态类型信息
     * @return SbsResult
     */
    @GetMapping("/campusDynamicTop")
    public SbsResult campusDynamicTop(){
        if (campusDynamicService.campusDynamicTop().size() <= 0){
            return SbsResult.fail("500","暂无数据");
        } else {
            return SbsResult.success(campusDynamicService.campusDynamicTop());
        }
    }

    /**
     * 根据类型查询校园动态信息
     * @param campusDynamicTypeId 类型id
     * @return
     */
    @PostMapping("/campusDynamicListByType")
    public SbsResult campusDynamicListByType(@RequestParam("campusDynamicTypeId") Integer campusDynamicTypeId){
        if (campusDynamicService.campusDynamicListByType(campusDynamicTypeId).size() == 0){
            return SbsResult.fail("500","暂无数据");
        } else {
            Map map = new HashMap();
            List<CampusDynamic> campusDynamicList = campusDynamicService.campusDynamicListByType(campusDynamicTypeId);
            List<CampusDynamicCollect> campusDynamicCollectList = campusDynamicCollectService.campusDynamicCollectList();
            map.put("campusDynamicList",campusDynamicList);
            map.put("campusDynamicCollectList",campusDynamicCollectList);
            return SbsResult.success(map);
        }
    }

    /**
     * 单条数据查询
     * @param campusDynamicId 校园动态id
     * @return
     */
    @PostMapping("/findCampusDynamicById")
    public SbsResult findCampusDynamicById(@RequestParam("campusDynamicId") Integer campusDynamicId){
        return SbsResult.success(campusDynamicService.searchCampusDynamicById(campusDynamicId));
    }

    /**
     * @Title: getPictureUrl
     * @Description: 从校园动态详情中获取移动端校园动态列表所显示的图片url
     * @param context 单位详情html代码
     * @return 第一张图片的url
     */
    @PostMapping("/getPictureUrl")
    public SbsResult getPictureUrl(@RequestParam("campusDynamicDescribe") String context){
        //取出context中的img标签
        Matcher matcher = Pattern.compile("<img.*src=(.*?)[^>]*?>").matcher(context);
        List<String> imageList = new ArrayList<String>();
        while(matcher.find()){
            imageList.add(matcher.group());
        }
        //对每个img标签匹配图片地址
        for(String url : imageList){
            Matcher pictureUrl = Pattern.compile("http:\"?(.*?)(\"|>|\\s+)").matcher(url);
            while(pictureUrl.find()){
                //这里因为业务需求，返回了第一个，可以根据自身需要返回List<String>
                return SbsResult.success(pictureUrl.group().substring(0, pictureUrl.group().length() - 1));
            }
        }
        return SbsResult.success();
    }
    /*=============================点赞=============================*/
    /*======================================教师点赞====================================*/

    /**
     * 根据教师工号查找点赞记录
     * @param teaNo 教师工号
     * @return
     */
    @PostMapping("/teaCollectList")
    public SbsResult teaCollectList(@RequestParam("teaNo") String teaNo){
        return SbsResult.success(campusDynamicCollectService.teaCollectList(teaNo));
    }

    /**
     * 查询所有成长记录家长点赞
     * @return
     */
    @GetMapping("/teaCampusCollectList")
    public SbsResult teaCampusCollectList(){
        return SbsResult.success(campusDynamicCollectService.teaCampusCollectList());
    }

    /**
     * 教师点赞信息添加
     * @param teaNo
     * @param campusDynamicId
     * @return
     */
    @PostMapping("/teaCollect")
    public SbsResult teaCollect(@RequestParam("teaNo") String teaNo,
                                      @RequestParam("campusDynamicId") Integer campusDynamicId){
        Teacher teacher = new Teacher();
        CampusDynamic campusDynamic = new CampusDynamic();
        CampusDynamicCollect campusDynamicCollect = new CampusDynamicCollect();
        teacher.setTeaNo(teaNo);
        campusDynamic.setCampusDynamicId(campusDynamicId);
        campusDynamicCollect.setTeacher(teacher);
        campusDynamicCollect.setCampusDynamic(campusDynamic);
        return SbsResult.success(campusDynamicCollectService.teaCollect(campusDynamicCollect));
    }

    /**
     * 修改
     * @param campusDynamicId
     * @param teaNo
     * @param collectState
     * @return
     */
    @PostMapping("/updateTeaCDState")
    public SbsResult updateTeaCDState(@RequestParam("teaNo") String teaNo,
                                      @RequestParam("campusDynamicId") Integer campusDynamicId,
                                      @RequestParam("collectState") Integer collectState){
        Teacher teacher = new Teacher();
        CampusDynamic campusDynamic = new CampusDynamic();
        CampusDynamicCollect campusDynamicCollect = new CampusDynamicCollect();
        teacher.setTeaNo(teaNo);
        campusDynamic.setCampusDynamicId(campusDynamicId);
        campusDynamicCollect.setTeacher(teacher);
        campusDynamicCollect.setCampusDynamic(campusDynamic);
        campusDynamicCollect.setCollectState(collectState);
        return SbsResult.success(campusDynamicCollectService.updateTeaState(campusDynamicCollect));
    }

    /*======================================家长点赞====================================*/
    /**
     * 查询所有成长记录家长点赞
     * @return
     */
    @GetMapping("/parCampusCollectList")
    public SbsResult parCampusCollectList(){
        return SbsResult.success(campusDynamicCollectService.parCampusCollectList());
    }

    /**
     * 根据家长id查找点赞记录
     * @param parId 家长id
     * @return
     */
    @PostMapping("/parCDCollectList")
    public SbsResult parCDCollectList(@RequestParam("parId") Integer parId){
        return SbsResult.success(campusDynamicCollectService.parCollectList(parId));
    }

    /**
     * 家长点赞信息添加
     * @param parId
     * @param campusDynamicId
     * @return
     */
    @PostMapping("/parDynamicCollect")
    public SbsResult parDynamicCollect(@RequestParam("parId") Integer parId,
                                      @RequestParam("campusDynamicId") Integer campusDynamicId){
        Parents parents = new Parents();
        CampusDynamic campusDynamic = new CampusDynamic();
        CampusDynamicCollect campusDynamicCollect = new CampusDynamicCollect();
        parents.setParId(parId);
        campusDynamic.setCampusDynamicId(campusDynamicId);
        campusDynamicCollect.setParents(parents);
        campusDynamicCollect.setCampusDynamic(campusDynamic);
        return SbsResult.success(campusDynamicCollectService.parCollect(campusDynamicCollect));
    }

    /**
     * @param parId
     * @param campusDynamicId
     * @param collectState
     * @return
     */
    @PostMapping("/updateParCDState")
    public SbsResult updateParCDState(@RequestParam("parId") Integer parId,
                                      @RequestParam("campusDynamicId") Integer campusDynamicId,
                                      @RequestParam("collectState") Integer collectState){
        Parents parents = new Parents();
        CampusDynamic campusDynamic = new CampusDynamic();
        CampusDynamicCollect campusDynamicCollect = new CampusDynamicCollect();
        parents.setParId(parId);
        campusDynamic.setCampusDynamicId(campusDynamicId);
        campusDynamicCollect.setParents(parents);
        campusDynamicCollect.setCampusDynamic(campusDynamic);
        campusDynamicCollect.setCollectState(collectState);
        return SbsResult.success(campusDynamicCollectService.updateParState(campusDynamicCollect));
    }

    /**
     * 修改点赞人数
     * @param campusDynamicId
     * @return
     */
    @PostMapping("/addCampusDynamicCollects")
    public SbsResult addCampusDynamicCollects(@RequestParam("campusDynamicId") Integer campusDynamicId){
        CampusDynamic campusDynamic = campusDynamicService.searchCampusDynamicById(campusDynamicId);
        Integer num = campusDynamic.getCampusDynamicCollects();
        Integer campusDynamicCollects = num+1;
        return SbsResult.success(campusDynamicService.addCollects(campusDynamicId,campusDynamicCollects));
    }

    /**
     * 修改点赞人数
     * @param campusDynamicId
     * @return
     */
    @PostMapping("/updateStatus")
    public SbsResult updateStatus(@RequestParam("campusDynamicId") int campusDynamicId){
        CampusDynamic campusDynamic = campusDynamicService.searchCampusDynamicById(campusDynamicId);
        Integer num = campusDynamic.getCampusDynamicCollects();
        Integer campusDynamicCollects = num-1;
        if (campusDynamicCollects <= 0){
            campusDynamicCollects = 0;
        }
        return SbsResult.success(campusDynamicService.addCollects(campusDynamicId,campusDynamicCollects));
    }
}
