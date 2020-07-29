package com.systop.sbs.mapper;

import com.systop.sbs.common.pojo.CampusDynamic;
import com.systop.sbs.common.pojo.Parents;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Program: sbs
 * @Description: TODO   parents的mapper
 * @Author: 贾小翠
 * @Date: 2020/7/29 14:15
 **/
@Mapper
public interface ParentsMapper {
    /**
     * 查询所有家长信息
     * @return list
     */
    @Select("select par.*,stu.* from parents par " +
            "INNER JOIN student stu ON par.stu_no=stu.stu_no " +
            "ORDER BY par.par_id desc")
    @Results(id = "parentsMap",value = {
            @Result(id = true,column = "par_id",property = "parId"),
            @Result(column = "par_name",property = "parName"),
            @Result(column = "par_pwd",property = "parPwd"),
            @Result(column = "par_phone",property = "parPhone"),
            @Result(column = "par_portrait",property = "parPortrait"),
            @Result(column = "par_online_status",property = "parOnlineStatus"),
            @Result(column = "remark",property = "remark"),
            @Result(property = "student",column = "stu_no",
                    one = @One(select = "com.systop.sbs.mapper.StudentMapper.stuBySno",
                            fetchType = FetchType.LAZY)),
    })
    List<Parents> searchParentsList();

    /**
     * 删除家长信息
     * @param parId 家长Id
     * @return
     */
    @Delete("delete from parents where par_id=#{parId}")
    Integer deleteParents(@Param("parId") Integer parId);

    /**
     * 添加家长信息
     * @param parents 家长
     * @return
     */
    @Insert("insert into parents (par_name,par_pwd,par_phone,par_portrait,stu_no,par_online_status,remark) " +
            "values (#{parName},#{parPwd},#{parPhone},#{parPortrait},#{student.stuNo},#{parOnlineStatus},#{remark})")
    Integer addParents(Parents parents);

    /**
     * 修改家长信息
     * @param parents 家长
     * @return
     */
    @Update("update parents set par_name=#{parName},par_pwd=#{parPwd},par_phone=#{parPhone},par_portrait=#{parPortrait}," +
            "stu_no=#{student.stuNo},par_online_status=#{parOnlineStatus},remark=#{remark} " +
            "WHERE par_id=#{parId}")
    Integer updateParents(Parents parents);


    /**
     * 根据id查询家长信息
     * @param parId 家长Id
     * @return
     */
    @Select("select * from parents where par_id = #{parId}")
    Parents searchParentsById(@Param("parId") Integer parId);
}