package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.Lrc;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/10 8:24
 **/
@Mapper
public interface LrcMapper {
//    查询所有歌词文件
    @Select("select * from lrc")
    List<Lrc> selectAllLrc();

//    按id查询歌词文件
@Select("select * from lrc where lrc_id = #{lrcId}")
Lrc selectLrcById(Integer lrcId);

//    添加歌词文件
    @Insert("insert into lrc (lrc_name,lrc_url) values (#{lrcName},#{lrcUrl})")
    Integer insertLrc(Lrc lrc);

//    删除歌词文件
    @Delete("delete from lrc where lrcId=#{lrcId}")
    Integer deleteLrc(Integer lrcId);
}
