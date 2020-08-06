package com.systop.sbs.api;

import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.service.CampusDynamicService;
import com.systop.sbs.service.CampusDynamicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
            return SbsResult.success(campusDynamicService.campusDynamicListByType(campusDynamicTypeId));
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
}
