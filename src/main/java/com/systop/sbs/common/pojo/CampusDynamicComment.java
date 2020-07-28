package com.systop.sbs.common.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Program: sbs
 * @Description: TODO 校园动态评论pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 11:03
 **/
@Data
public class CampusDynamicComment {
    //校园动态评论id
    private Integer campusCommentId;
    //校园动态id
    private CampusDynamic campusDynamic;
    //被回复的评论的id，默认为0，有则为其id
    private Integer rid;
    //家长id
    private Parents parents;
    //老师id
    private Teacher teacher;
    //评论的内容
    private String comments;
    //评论的时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;
    //备注
    private String remark;
}
