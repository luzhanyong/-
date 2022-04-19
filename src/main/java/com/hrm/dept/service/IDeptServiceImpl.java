package com.hrm.dept.service;

import com.hrm.commons.benas.Dept;
import com.hrm.dept.dao.IDeptDao;
import com.hrm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/3/18 0018
 */
@Service
public class IDeptServiceImpl implements IDeptService {
    @Autowired
    private IDeptDao deptDao;

    @Override
    public List<Dept> findDept(String name, PageModel pageModel) {
        return deptDao.selectDept(name,pageModel);
    }

    @Override
    public int findDeptCount(String name) {
        return deptDao.selectDeptCount(name);
    }

    @Override
    public Dept findDeptById(Integer id) {
        return deptDao.selectDeptById(id);
    }

    @Override
    public int modifyDept(Dept dept) {
        return deptDao.updateDept(dept);
    }

    @Override
    public int removeDept(Integer[] ids) {
        return deptDao.deleteDept(ids);
    }

    @Override
    public int addDept(Dept dept) {
        return deptDao.insertDept(dept);
    }
}
