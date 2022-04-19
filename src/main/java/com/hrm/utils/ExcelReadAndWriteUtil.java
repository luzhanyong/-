package com.hrm.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.hrm.commons.benas.*;
import com.hrm.employee.service.EmployeeService;

import java.util.List;

/**
 * @author 卢占勇
 * @desc
 * @date 2022/3/22
 */
public class ExcelReadAndWriteUtil {

    //校级读excel
    public static void excelReadSchoolLeader(String filePath, EmployeeService employeeService){
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(filePath, SchoolLeader.class, new SchoolLeaderListener(employeeService)).sheet().doRead();
    }

    //处级读excel
    public static void excelReadSchoolchuLeader(String filePath, EmployeeService employeeService){
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件Chu动关闭
        EasyExcel.read(filePath, SchoolChuLeader.class, new SchoolChuLeaderListener(employeeService)).sheet().headRowNumber(2).doRead();
    }

    //科级读excel
    public static void excelReadSchoolkeLeader(String filePath, EmployeeService employeeService){
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件CKe动关闭
        EasyExcel.read(filePath, SchoolKeLeader.class, new SchoolKeLeaderListener(employeeService)).sheet().headRowNumber(2).doRead();
    }



    //校级写
    public static void excelWriteSchoolLeader(String fileAbsolute,EmployeeService employeeService){
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.write(fileAbsolute, SchoolLeader.class).sheet("模板").doWrite(employeeService.selectAllSchoolLeader());
    }

    //处级写
    public static void excelWriteSchoolchuLeader(String fileAbsolute,EmployeeService employeeService){
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.write(fileAbsolute, SchoolChuLeaderOut.class).sheet("模板").doWrite(employeeService.selectAllSchoolchuLeader());
    }

    //科级写
    public static void excelWriteSchoolkeLeader(String fileAbsolute,EmployeeService employeeService){
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.write(fileAbsolute, SchoolKeLeaderOut.class).sheet("模板").doWrite(employeeService.selectAllSchoolkeLeader());
    }

}
