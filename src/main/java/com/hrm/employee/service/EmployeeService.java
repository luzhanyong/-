package com.hrm.employee.service;

import com.hrm.commons.benas.*;

import java.util.List;

public interface EmployeeService {

    /**
     * 查找所有校级领导
     * @return
     */
    List<SchoolLeader> selectAllSchoolLeader();

    /**
     * 添加校级领导
     */
    int addSchoolLeader(SchoolLeader schoolLeader);

    /**
     * 根据名字查询领导信息
     * @param name
     * @return
     */
    List<SchoolLeader> selectSchoolLeaderByName(String name);

    /**
     * 根据id查询校领导信息
     * @param id
     * @return
     */
    SchoolLeader findSchoolLeaderById(int id);

    /**
     * 更新校领导信息
     * @param schoolLeader
     * @return
     */
    int updataSchoolLeaderById(SchoolLeader schoolLeader);

    /**
     * 根据id删除领导信息
     * @param id
     * @return
     */
    int deleteSchoolLeaderById(Integer id);


    //处级

    /**
     * 查找所有处级领导
     * @return
     */
    List<SchoolChuLeader> selectAllSchoolchuLeader();

    /**
     * 添加校级领导
     */
    int addSchoolchuLeader(SchoolChuLeader schoolLeader);

    /**
     * 根据名字查询领导信息
     * @param name
     * @return
     */
    List<SchoolChuLeader> selectSchoolchuLeaderByName(String name);

    /**
     * 根据id查询处领导信息
     * @param id
     * @return
     */
    SchoolChuLeader findSchoolchuLeaderById(int id);

    /**
     * 更新处领导信息
     * @param schoolLeader
     * @return
     */
    int updataSchoolchuLeaderById(SchoolChuLeader schoolLeader);

    /**
     * 根据id删处领导信息
     * @param id
     * @return
     */
    int deleteSchoolchuLeaderById(Integer id);


    //科级


    /**
     * 查找所有科级领导
     * @return
     */
    List<SchoolKeLeader> selectAllSchoolkeLeader();

    /**
     * 添加科级领导
     */
    int addSchoolkeLeader(SchoolKeLeader schoolkeLeader);

    /**
     * 根据名字查询领导信息
     * @param name
     * @return
     */
    List<SchoolKeLeader> selectSchoolkeLeaderByName(String name);

    /**
     * 根据id查询科领导信息
     * @param id
     * @return
     */
    SchoolKeLeader findSchoolkeLeaderById(int id);

    /**
     * 更新科领导信息
     * @param schoolkeLeader
     * @return
     */
    int updataSchoolkeLeaderById(SchoolKeLeader schoolkeLeader);

    /**
     * 根据id删科领导信息
     * @param id
     * @return
     */
    int deleteSchoolkeLeaderById(Integer id);

    /**
     * 从excal保存校级领导
     * @param list
     * @return
     */
    int saveSchoolLeader(List<SchoolLeader> list);

    /**
     * 从excal保存处级领导
     * @param list
     * @return
     */
    int saveSchoolchuLeader(List<SchoolChuLeader> list);

    /**
     * 从excal保存科级领导
     * @param list
     * @return
     */
    int saveSchoolkeLeader(List<SchoolKeLeader> list);

}
