package com.systop.sbs.api;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.systop.sbs.common.pojo.Parents;
import com.systop.sbs.common.util.ComFunctionUtils;
import com.systop.sbs.common.util.SbsResult;
import com.systop.sbs.common.util.WebClientUtils;
import com.systop.sbs.service.ParentsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Program: com.systop.sbs.api
 * @Description: TODO
 * @Author: ZhangLi
 * @Date: 2020/8/3 11:23
 **/
@RestController
@CrossOrigin
@RequestMapping("/parentsApi")
public class ParentsApi {

    @Autowired
    private ParentsService parentsService;

    /**
     * 获取验证码
     */
    private static String APP_ID = "43367542";
    private static String APPSecret = "Mg7n0hYP";

    @RequestMapping("/getCode")
    public void getCode(@RequestParam("parPhone") String parPhone, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = null;

        String url = "/api/sms";
        String code = ComFunctionUtils.createRandom(4);
        System.out.println("验证码："+code);

        HttpSession session = request.getSession();
        json = new JSONObject();
        json.put("parPhone", parPhone);
        json.put("code", code);
        json.put("createTime", System.currentTimeMillis());
        // 将认证码存入SESSION
        session.setAttribute("code", json);
        session.setAttribute("parPhone",json);

        MultiValueMap<String, String> params = createParams(parPhone, code);
        Map<String, Object> map = WebClientUtils.wcGet(url, params);
        //返回格式 {"errcode":0,"errmsg":"SUCCESS"}
        System.out.println(new Gson().toJson(map));
    }

    private static MultiValueMap<String, String> createParams(String phone, String code) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>(4);
        map.add("appid", APP_ID);
        map.add("appsecret", APPSecret);
        map.add("mobile", phone);
        map.add("code", code);
        return map;
    }


    /**
     * 家长注册
     * @param parents 家长
     * @param parPhone 电话
     * @return
     */
    @RequestMapping("/registerParents")
    public SbsResult registerParents(Parents parents,@RequestParam("parPhone") String parPhone,
                                     HttpServletRequest request, HttpServletResponse response,HttpSession session ){

        String code = request.getParameter("code");
        JSONObject json = (JSONObject)request.getSession().getAttribute("code");
        if (json == null){
            renderData(response, "验证码为空");
            return SbsResult.fail("500","验证码为空");
        }
        if(!json.getString("parPhone").equals(parPhone)){
            renderData(response, "手机号错误");
            return SbsResult.fail("500","手机号错误");
        }
        if(!json.getString("code").equals(code)){
            renderData(response, "验证码错误");
            return SbsResult.fail("500","验证码错误");
        }
        if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
            renderData(response, "验证码已过期");
            return SbsResult.fail("500","验证码已过期");
        }

        parents.setParPhone(parPhone);
        parents.setParPortrait("http://localhost:8080/images/20200803/11/202008031103009978c4986e64c.jpg");
        parents.setParOnlineStatus(0);

        parentsService.registerParents(parents);
        session.setAttribute("parentSession",parents);

        return SbsResult.success(parents);
    }

    protected void renderData(HttpServletResponse response, String data){
        try {
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 家长登录
     * @param parPhone 电话
     * @param parPwd  密码
     * @param session
     * @return
     */
    @RequestMapping("/parentsLogin")
    public SbsResult parentsLogin(@Param("parPhone") String parPhone, @Param("parPwd") String parPwd, HttpSession session){
        Parents parents = parentsService.parentsLogin(parPhone, parPwd);
        if (parents != null){
            parents.setParOnlineStatus(0);
            parentsService.updateParents(parents);
            session.setAttribute("parentSession",parents);
            return SbsResult.success(parents);
        }else {
            return SbsResult.fail("500","没有数据");
        }
    }

    /**
     * 忘记密码
     * @param parPhone 电话
     * @param parPwd 密码
     * @return
     */
    @RequestMapping("/forgetParentsPwd")
    public SbsResult forgetParentsPwd(@Param("parPhone") String parPhone, @Param("parPwd") String parPwd,
                                      HttpServletRequest request, HttpServletResponse response){
        String code = request.getParameter("code");
        JSONObject json = (JSONObject)request.getSession().getAttribute("code");
        if (json == null){
            renderData(response, "验证码为空");
            return SbsResult.fail("500","验证码为空");
        }
        if(!json.getString("parPhone").equals(parPhone)){
            renderData(response, "手机号错误");
            return SbsResult.fail("500","手机号错误");
        }
        if(!json.getString("code").equals(code)){
            renderData(response, "验证码错误");
            return SbsResult.fail("500","验证码错误");
        }
        if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
            renderData(response, "验证码已过期");
            return SbsResult.fail("500","验证码已过期");
        }

        return SbsResult.success(parentsService.forgetParentsPwd(parPwd, parPhone));
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/parentsLogout")
    public SbsResult parentsLogout(HttpSession session){
        Parents parents =(Parents) session.getAttribute("parentSession");
        Parents parent = parentsService.searchParentsById(parents.getParId());
        if (parent != null){
            parent.setParOnlineStatus(1);
            parentsService.parentsLogout(parent);
            session.removeAttribute("parentSession");
            return SbsResult.success(200,"成功");
        }else {
            return SbsResult.fail("500","没有数据");
        }
    }

    /**
     * session获取登录的用户并展示相应信息
     * @param session
     * @return
     */
    @RequestMapping("/showParentById")
    public SbsResult showParentById(HttpSession session){
        Parents parents =(Parents) session.getAttribute("parentSession");
        return SbsResult.success(parentsService.searchParentsById(parents.getParId()));
    }

}
