package com.hrm.employee.dao;

import com.hrm.commons.benas.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {

    /**
     * 查询所有校级领导
     * @return
     */
    List<SchoolLeader> selectAllSchoolLeader();

    /**
     * 插入一个校级领导
     * @param schoolLeader
     * @return
     */
    int insertSchoolLeader(SchoolLeader schoolLeader);

    /**
     * 根据姓名查找一个校级领导信息
     */
    List<SchoolLeader> selectSchoolLeaderByName(String name);

    /**
     * 根据id查找一个校级领导信息
     */
    SchoolLeader selectSchoolLeaderById(Integer id);

    /**
     * 更新用户
     * @param
     * @return
     */
    int updataSchoolLeaderById(SchoolLeader schoolLeader);

    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    int deleteSchoolLeaderById(Integer id);


    //处级


    /**
     * 查询所有处级领导
     * @return
     */
    List<SchoolChuLeader> selectAllSchoolchuLeader();

    /**
     * 插入一个处级领导
     * @param schoolLeader
     * @return
     */
    int insertSchoolchuLeader(SchoolChuLeader schoolLeader);

    /**
     * 根据姓名查找一个处级领导信息
     */
    List<SchoolChuLeader> selectSchoolchuLeaderByName(String name);

    /**
     * 根据id查找一个校级领导信息
     */
    SchoolChuLeader selectSchoolchuLeaderById(Integer id);

    /**
     * 更新用户
     * @param
     * @return
     */
    int updataSchoolchuLeaderById(SchoolChuLeader schoolLeader);

    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    int deleteSchoolchuLeaderById(Integer id);


    //科级


    /**
     * 查询所有处级领导
     * @return
     */
    List<SchoolKeLeader> selectAllSchoolkeLeader();

    /**
     * 插入一个处级领导
     * @param schoolkeLeader
     * @return
     */
    int insertSchoolkeLeader(SchoolKeLeader schoolkeLeader);

    /**
     * 根据姓名查找一个处级领导信息
     */
    List<SchoolKeLeader> selectSchoolkeLeaderByName(String name);

    /**
     * 根据id查找一个校级领导信息
     */
    SchoolKeLeader selectSchoolkeLeaderById(Integer id);

    /**
     * 更新用户
     * @param
     * @return
     */
    int updataSchoolkeLeaderById(SchoolKeLeader schoolkeLeader);

    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    int deleteSchoolkeLeaderById(Integer id);


    //excal信息导入

    /**
     * 校级领导信息管理
     * @param schoolLeaders
     * @return
     */
    int insertSchoolLeaderByExcal(@Param("schoolLeaders") List<SchoolLeader> schoolLeaders);

    /**
     * 处级领导信息管理
     * @param schoolchuLeaders
     * @return
     */
    int insertSchoolchuLeaderByExcal(@Param("schoolchuLeaders") List<SchoolChuLeader> schoolchuLeaders);

    /**
     * 科级领导信息管理
     * @param schoolkeLeaders
     * @return
     */
    int insertSchoolkeLeaderByExcal(@Param("schoolkeLeaders") List<SchoolKeLeader> schoolkeLeaders);
}
