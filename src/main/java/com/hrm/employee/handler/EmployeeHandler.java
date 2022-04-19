package com.hrm.employee.handler;

import com.hrm.commons.benas.*;
import com.hrm.employee.service.EmployeeService;
import com.hrm.utils.ExcelReadAndWriteUtil;
import com.hrm.utils.FileDownloadUtil;
import com.hrm.utils.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeHandler {
    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping("/findSchoolleader")
    public List<SchoolLeader> findEmployee(){
        List<SchoolLeader> schoolLeaders = employeeService.selectAllSchoolLeader();
        return schoolLeaders;
    }

    @ResponseBody
    @RequestMapping("/addSchoolleader")
    public Result addEmployee(SchoolLeader schoolLeader){
        int i = employeeService.addSchoolLeader(schoolLeader);
        Result result = null;
        if(i == 0){
            result = new Result(1,"FAIL");
        }else{
            result = new Result(0, "ok");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/findSchoolLeaderByName")
    public List<SchoolLeader> findSchoolLeaderByName(@RequestBody Map<String,String> nameMap){
        String name = nameMap.get("name");
        List<SchoolLeader> schoolLeader = employeeService.selectSchoolLeaderByName(name);
        return schoolLeader;
    }

    @RequestMapping("/findSchoolLeaderById/{id}")
    public String findSchoolLeaderById(@PathVariable("id") String id, HttpSession session){
        int intId = Integer.parseInt(id);
        SchoolLeader schoolLeader = employeeService.findSchoolLeaderById(intId);
        session.setAttribute("schoolLeader",schoolLeader);
        return "/jsp/leader/updateSchoolLeader.jsp";
    }

    @ResponseBody
    @RequestMapping("/updateSchoolLeader")
    public Result findSchoolLeaderById(SchoolLeader schoolLeader){
        int i = employeeService.updataSchoolLeaderById(schoolLeader);
        Result result = new Result();
        if (i==0){
            result.setCode(1);
            result.setMessage("更新错误");
        }else {
            result.setCode(0);
            result.setMessage("更新成功");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteSchoolLeaderById/{id}")
    public Result deleteSchoolLeaderById(@PathVariable("id") String id){
        int intId = Integer.parseInt(id);
        int i = employeeService.deleteSchoolLeaderById(intId);
        Result result = new Result();
        if (i==0){
            result.setCode(1);
            result.setMessage("FAIL");
        }else {
            result.setCode(0);
            result.setMessage("删除成功");
        }
        return result;
    }

    //处级

    @ResponseBody
    @RequestMapping("/findSchoolchuleader")
    public List<SchoolChuLeader> findSchoolchuleader(){
        List<SchoolChuLeader> schoolchuLeaders = employeeService.selectAllSchoolchuLeader();
        return schoolchuLeaders;
    }

    @ResponseBody
    @RequestMapping("/addSchoolchuleader")
    public Result addSchoolchuleader(SchoolChuLeader schoolchuLeader){
        int i = employeeService.addSchoolchuLeader(schoolchuLeader);
        Result result = null;
        if(i == 0){
            result = new Result(1,"FAIL");
        }else{
            result = new Result(0, "ok");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/findSchoolchuLeaderByName")
    public List<SchoolChuLeader> findSchoolchuLeaderByName(@RequestBody Map<String,String> nameMap){
        String name = nameMap.get("name");
        List<SchoolChuLeader> schoolchuLeader = employeeService.selectSchoolchuLeaderByName(name);
        return schoolchuLeader;
    }

    @RequestMapping("/findSchoolchuLeaderById/{id}")
    public String findSchoolchuLeaderById(@PathVariable("id") String id, HttpSession session){
        int intId = Integer.parseInt(id);
        SchoolChuLeader schoolchuLeader = employeeService.findSchoolchuLeaderById(intId);
        session.setAttribute("schoolchuLeader",schoolchuLeader);
        return "/jsp/leader/updateSchoolchuLeader.jsp";
    }

    @ResponseBody
    @RequestMapping("/updateSchoolchuLeader")
    public Result updateSchoolchuLeader(SchoolChuLeader schoolchuLeader){
        int i = employeeService.updataSchoolchuLeaderById(schoolchuLeader);
        Result result = new Result();
        if (i==0){
            result.setCode(1);
            result.setMessage("更新错误");
        }else {
            result.setCode(0);
            result.setMessage("更新成功");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteSchoolchuLeaderById/{id}")
    public Result deleteSchoolchuLeaderById(@PathVariable("id") String id){
        int intId = Integer.parseInt(id);
        int i = employeeService.deleteSchoolchuLeaderById(intId);
        Result result = new Result();
        if (i==0){
            result.setCode(1);
            result.setMessage("FAIL");
        }else {
            result.setCode(0);
            result.setMessage("删除成功");
        }
        return result;
    }


    //科级


    @ResponseBody
    @RequestMapping("/findSchoolkeleader")
    public List<SchoolKeLeader> findSchoolkeleader(){
        List<SchoolKeLeader> schoolkeLeaders = employeeService.selectAllSchoolkeLeader();
        return schoolkeLeaders;
    }

    @ResponseBody
    @RequestMapping("/addSchoolkeleader")
    public Result addSchoolkeleader(SchoolKeLeader schoolkeLeader){
        int i = employeeService.addSchoolkeLeader(schoolkeLeader);
        Result result = null;
        if(i == 0){
            result = new Result(1,"FAIL");
        }else{
            result = new Result(0, "ok");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/findSchoolkeLeaderByName")
    public List<SchoolKeLeader> findSchoolkeLeaderByName(@RequestBody Map<String,String> nameMap){
        String name = nameMap.get("name");
        List<SchoolKeLeader> schoolkeLeader = employeeService.selectSchoolkeLeaderByName(name);
        return schoolkeLeader;
    }

    @RequestMapping("/findSchoolkeLeaderById/{id}")
    public String findSchoolkeLeaderById(@PathVariable("id") String id, HttpSession session){
        int intId = Integer.parseInt(id);
        SchoolKeLeader schoolkeLeader = employeeService.findSchoolkeLeaderById(intId);
        session.setAttribute("schoolkeLeader",schoolkeLeader);
        return "/jsp/leader/updateSchoolkeLeader.jsp";
    }

    @ResponseBody
    @RequestMapping("/updateSchoolkeLeader")
    public Result updateSchoolkeLeader(SchoolKeLeader schoolkeLeader){
        int i = employeeService.updataSchoolkeLeaderById(schoolkeLeader);
        Result result = new Result();
        if (i==0){
            result.setCode(1);
            result.setMessage("更新错误");
        }else {
            result.setCode(0);
            result.setMessage("更新成功");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteSchoolkeLeaderById/{id}")
    public Result deleteSchoolkeLeaderById(@PathVariable("id") String id){
        int intId = Integer.parseInt(id);
        int i = employeeService.deleteSchoolkeLeaderById(intId);
        Result result = new Result();
        if (i==0){
            result.setCode(1);
            result.setMessage("FAIL");
        }else {
            result.setCode(0);
            result.setMessage("删除成功");
        }
        return result;
    }

    //校级上传
    @ResponseBody
    @RequestMapping("/fileUploadXexcel")
    public Result fileUploadXexcel(@RequestParam("xexcel") MultipartFile excel,
                     HttpSession session){

        System.out.println(excel.getOriginalFilename());
        if (excel.getOriginalFilename() == null || "".equals(excel.getOriginalFilename())){
            return new Result(1,"不能发送空文件");
        }

        String dirName = "校级";
        String fileName = "校级领导信息管理.xlsx";
        Result result = FileUploadUtil.fileUploadXexcel(excel, session, dirName, fileName);
        if (result.getCode() == 0){
            String filePath = result.getMessage();
            ExcelReadAndWriteUtil.excelReadSchoolLeader(filePath,employeeService);
            result.setMessage("导入成功");
            return result;
        }else{
            return result;
        }
    }
    //校级下载
    @RequestMapping("/fileDownloadXexcel")
    public ResponseEntity<byte[]> fileDownloadXexcel(HttpSession session){
        String dirName = "校级";
        String fileName = "校级领导花名册.xlsx";
        //创建文件
        String fileAbsolute = FileDownloadUtil.fileCreate(session, dirName, fileName);
        //写excel
        ExcelReadAndWriteUtil.excelWriteSchoolLeader(fileAbsolute,employeeService);
        //返回excel
        File file = new File(fileAbsolute);
        try {
            byte[] bytes = FileUtils.readFileToByteArray(file);
            HttpHeaders headers=new HttpHeaders();
            // Content-Disposition就是当用户想把请求所得的内容存为一个文件的时候提供一个默认的文件名。
            headers.set("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
            headers.set("charsetEncoding","utf-8");
            headers.set("content-type","multipart/form-data");
            ResponseEntity<byte[]> entity =new ResponseEntity<>(bytes,headers, HttpStatus.OK);
            return entity;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    //处级上传
    @ResponseBody
    @RequestMapping("/fileUploadCexcel")
    public Result fileUploadCexcel(@RequestParam("cexcel") MultipartFile excel,
                                   HttpSession session){

        if (excel.getOriginalFilename() == null || "".equals(excel.getOriginalFilename())){
            return new Result(1,"不能发送空文件");
        }
        String dirName = "处级";
        String fileName = "处级领导信息管理.xls";
        Result result = FileUploadUtil.fileUploadCexcel(excel, session, dirName, fileName);
        if (result.getCode() == 0){
            String filePath = result.getMessage();
            ExcelReadAndWriteUtil.excelReadSchoolchuLeader(filePath,employeeService);
            result.setMessage("导入成功");
            return result;
        }else{
            return result;
        }
    }

    //处级下载
    @RequestMapping("/fileDownloadCexcel")
    public ResponseEntity<byte[]> fileDownloadCexcel(HttpSession session){
        String dirName = "处级";
        String fileName = "处级领导花名册.xls";
        //创建文件
        String fileAbsolute = FileDownloadUtil.fileCreate(session, dirName, fileName);
        //写excel
        ExcelReadAndWriteUtil.excelWriteSchoolchuLeader(fileAbsolute,employeeService);
        //返回excel
        File file = new File(fileAbsolute);
        try {
            byte[] bytes = FileUtils.readFileToByteArray(file);
            HttpHeaders headers=new HttpHeaders();
            // Content-Disposition就是当用户想把请求所得的内容存为一个文件的时候提供一个默认的文件名。
            headers.set("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
            headers.set("charsetEncoding","utf-8");
            headers.set("content-type","multipart/form-data");
            ResponseEntity<byte[]> entity =new ResponseEntity<>(bytes,headers, HttpStatus.OK);
            return entity;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


    //科级上传
    @ResponseBody
    @RequestMapping("/fileUploadKexcel")
    public Result fileUploadKexcel(@RequestParam("kexcel") MultipartFile excel,
                                   HttpSession session){

        System.out.println(excel.getOriginalFilename());
        if (excel.getOriginalFilename() == null || "".equals(excel.getOriginalFilename())){
            return new Result(1,"不能发送空文件");
        }

        String dirName = "科级";
        String fileName = "科级领导信息管理.xls";
        Result result = FileUploadUtil.fileUploadKexcel(excel, session, dirName, fileName);
        if (result.getCode() == 0){
            String filePath = result.getMessage();
            ExcelReadAndWriteUtil.excelReadSchoolkeLeader(filePath,employeeService);
            result.setMessage("导入成功");
            return result;
        }else{
            return result;
        }
    }

    //科级下载
    @RequestMapping("/fileDownloadKexcel")
    public ResponseEntity<byte[]> fileDownloadKexcel(HttpSession session){
        String dirName = "科级";
        String fileName = "科级领导花名册.xls";
        //创建文件
        String fileAbsolute = FileDownloadUtil.fileCreate(session, dirName, fileName);
        //写excel
        ExcelReadAndWriteUtil.excelWriteSchoolkeLeader(fileAbsolute,employeeService);
        //返回excel
        File file = new File(fileAbsolute);
        try {
            byte[] bytes = FileUtils.readFileToByteArray(file);
            HttpHeaders headers=new HttpHeaders();
            // Content-Disposition就是当用户想把请求所得的内容存为一个文件的时候提供一个默认的文件名。
            headers.set("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
            headers.set("charsetEncoding","utf-8");
            headers.set("content-type","multipart/form-data");
            ResponseEntity<byte[]> entity =new ResponseEntity<>(bytes,headers, HttpStatus.OK);
            return entity;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}

