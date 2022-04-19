package com.hrm.dept.dao;

import com.hrm.commons.benas.Dept;
import com.hrm.utils.PageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/3/18 0018
 */
public interface IDeptDao {
    List<Dept> selectDept(@Param("name") String name,@Param("pageModel") PageModel pageModel);

    int selectDeptCount(String name);

    Dept selectDeptById(Integer id);

    int updateDept(Dept dept);

    int deleteDept(Integer[] ids);

    int insertDept(Dept dept);
}
