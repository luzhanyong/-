package com.hrm.dept.handler;

import com.hrm.commons.benas.Dept;
import com.hrm.dept.service.IDeptService;
import com.hrm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/3/18 0018
 */
@Controller
@RequestMapping("/dept")
public class DeptHandler {
    @Autowired
    private IDeptService deptService;

    @RequestMapping("/findDept")
    public String findDept(String name, @RequestParam(defaultValue = "1") Integer pageIndex, Model model){
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        List<Dept> depts = deptService.findDept(name,pageModel);
        model.addAttribute("depts",depts);
        //查询部门记录数
        int recordCount = deptService.findDeptCount(name);
        pageModel.setRecordCount(recordCount);
        model.addAttribute("pageModel",pageModel);
        model.addAttribute("name",name);

        // for (Dept dept : depts) {
        //     System.out.println(dept);
        // }
        return "/jsp/dept/dept.jsp";
    }

    @RequestMapping("/findDeptById")
    public String findDeptById(Integer id,int pageIndex,Model model){
        //根据ID查询修改的部门
        Dept dept = deptService.findDeptById(id);
        model.addAttribute("dept",dept);
        model.addAttribute("pageIndex",pageIndex);
        return "/jsp/dept/showUpdateDept.jsp";
    }

    @RequestMapping("/modifyDept")
    @ResponseBody   //返回数据作为响应体中的数据，而不是对应的视图地址
    public String modifyDept(Dept dept){

        int rows = deptService.modifyDept(dept);
        if (rows > 0){
            return "OK";
        }else {
            return "FAIL";
        }
    }

    @RequestMapping("/removeDept")
    @ResponseBody
    public String removeDept(Integer[] ids){

        try {
            int rows = deptService.removeDept(ids);
            if (rows == ids.length){
                return "OK";
            }else {
                return "FAIL";
            }
        }catch (DataIntegrityViolationException e){
            return "ERROR";
        }
    }

    @RequestMapping("/addDept")
    @ResponseBody
    public Object addDept(Dept dept){
        int rows = deptService.addDept(dept);
        if (rows > 0){
            int recordCount = deptService.findDeptCount(null);
            PageModel pageModel = new PageModel();
            pageModel.setRecordCount(recordCount);
            int totalSize = pageModel.getTotalSize();
            return totalSize;
        }else {
            return "FAIL";
        }
    }

}
