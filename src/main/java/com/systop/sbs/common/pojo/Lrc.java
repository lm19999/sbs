package com.systop.sbs.common.pojo;

import lombok.Data;

/**
 * @Program: sbs
 * @Description: 歌词文件实体类
 * @Author: liumiao
 * @Date: 2020/8/10 8:22
 **/
@Data
public class Lrc {
    //id,主键
    private Integer lrcId;
    //歌词文件名称
    private String lrcName;
    //歌词文件
    private String lrcUrl;
}
