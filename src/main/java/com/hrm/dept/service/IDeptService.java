package com.hrm.dept.service;

import com.hrm.commons.benas.Dept;
import com.hrm.utils.PageModel;

import java.util.List;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/3/18 0018
 */
public interface IDeptService {
    List<Dept> findDept(String name, PageModel pageModel);

    int findDeptCount(String name);

    Dept findDeptById(Integer id);

    int modifyDept(Dept dept);

    int removeDept(Integer[] ids);

    int addDept(Dept dept);
}
