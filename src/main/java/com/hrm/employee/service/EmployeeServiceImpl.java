package com.hrm.employee.service;

import com.hrm.commons.benas.*;
import com.hrm.employee.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public List<SchoolLeader> selectAllSchoolLeader() {
        return employeeDao.selectAllSchoolLeader();
    }

    @Override
    public int addSchoolLeader(SchoolLeader schoolLeader) {
        int i = employeeDao.insertSchoolLeader(schoolLeader);
        System.out.println(i);
        return i;
    }

    @Override
    public List<SchoolLeader> selectSchoolLeaderByName(String name) {
        List<SchoolLeader> schoolLeader = employeeDao.selectSchoolLeaderByName(name);
        return schoolLeader;
    }

    @Override
    public SchoolLeader findSchoolLeaderById(int id) {
        SchoolLeader schoolLeaders = employeeDao.selectSchoolLeaderById(id);
        return schoolLeaders;
    }

    @Override
    public int updataSchoolLeaderById(SchoolLeader schoolLeader) {
        int i = employeeDao.updataSchoolLeaderById(schoolLeader);
        return i;
    }

    @Override
    public int deleteSchoolLeaderById(Integer id) {
        int i = employeeDao.deleteSchoolLeaderById(id);
        return i;
    }

    //处级

    @Override
    public List<SchoolChuLeader> selectAllSchoolchuLeader() {
        return employeeDao.selectAllSchoolchuLeader();
    }

    @Override
    public int addSchoolchuLeader(SchoolChuLeader schoolchuLeader) {
        int i = employeeDao.insertSchoolchuLeader(schoolchuLeader);
        System.out.println(i);
        return i;
    }

    @Override
    public List<SchoolChuLeader> selectSchoolchuLeaderByName(String name) {
        List<SchoolChuLeader> schoolchuLeader = employeeDao.selectSchoolchuLeaderByName(name);
        return schoolchuLeader;
    }

    @Override
    public SchoolChuLeader findSchoolchuLeaderById(int id) {
        SchoolChuLeader schoolchuLeaders = employeeDao.selectSchoolchuLeaderById(id);
        return schoolchuLeaders;
    }

    @Override
    public int updataSchoolchuLeaderById(SchoolChuLeader schoolchuLeader) {
        int i = employeeDao.updataSchoolchuLeaderById(schoolchuLeader);
        return i;
    }

    @Override
    public int deleteSchoolchuLeaderById(Integer id) {
        int i = employeeDao.deleteSchoolchuLeaderById(id);
        return i;
    }


    //科级


    @Override
    public List<SchoolKeLeader> selectAllSchoolkeLeader() {
        return employeeDao.selectAllSchoolkeLeader();
    }

    @Override
    public int addSchoolkeLeader(SchoolKeLeader schoolkeLeader) {
        int i = employeeDao.insertSchoolkeLeader(schoolkeLeader);
        System.out.println(i);
        return i;
    }

    @Override
    public List<SchoolKeLeader> selectSchoolkeLeaderByName(String name) {
        List<SchoolKeLeader> schoolkeLeader = employeeDao.selectSchoolkeLeaderByName(name);
        return schoolkeLeader;
    }

    @Override
    public SchoolKeLeader findSchoolkeLeaderById(int id) {
        SchoolKeLeader schoolkeLeaders = employeeDao.selectSchoolkeLeaderById(id);
        return schoolkeLeaders;
    }

    @Override
    public int updataSchoolkeLeaderById(SchoolKeLeader schoolkeLeader) {
        int i = employeeDao.updataSchoolkeLeaderById(schoolkeLeader);
        return i;
    }

    @Override
    public int deleteSchoolkeLeaderById(Integer id) {
        int i = employeeDao.deleteSchoolkeLeaderById(id);
        return i;
    }

    public int saveSchoolLeader(List<SchoolLeader> list){
        int i = employeeDao.insertSchoolLeaderByExcal(list);
        return i;
    }

    public int saveSchoolchuLeader(List<SchoolChuLeader> list){
        int i = employeeDao.insertSchoolchuLeaderByExcal(list);
        return i;
    }

    public int saveSchoolkeLeader(List<SchoolKeLeader> list){
        int i = employeeDao.insertSchoolkeLeaderByExcal(list);
        return i;
    }
}
