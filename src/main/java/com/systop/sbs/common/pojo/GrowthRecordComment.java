package com.systop.sbs.common.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Program: sbs
 * @Description: TODO 成长记录评论pojo类
 * @Author: 贾小翠
 * @Date: 2020/7/28 10:42
 **/
@Data
public class GrowthRecordComment {
    //成长记录评论id
    private Integer growthCommentId;
    //成长记录id
    private GrowthRecord growthRecord;
    //被回复的评论的id，默认为0，有则为其id
    private Integer growthCommentRid;
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
