package com.hrm.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.hrm.commons.benas.SchoolChuLeader;
import com.hrm.commons.benas.SchoolKeLeader;
import com.hrm.commons.benas.SchoolLeader;
import com.hrm.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author 卢占勇
 * @desc
 * @date 2022/3/22
 */

@Slf4j
public class SchoolChuLeaderListener implements ReadListener<SchoolChuLeader> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    /*Chu    * 缓存的数据
     */
    private List<SchoolChuLeader> cachedSchoolchuLeaderList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    private EmployeeService employeeService;

    public SchoolChuLeaderListener(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void invoke(SchoolChuLeader schoolchuLeader, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(schoolchuLeader));
        cachedSchoolchuLeaderList.add(schoolchuLeader);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedSchoolchuLeaderList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            cachedSchoolchuLeaderList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("{}条数据，开始存储数据库！", cachedSchoolchuLeaderList.size());
        employeeService.saveSchoolchuLeader(cachedSchoolchuLeaderList);
        log.info("存储数据库成功！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", cachedSchoolchuLeaderList.size());
        employeeService.saveSchoolchuLeader(cachedSchoolchuLeaderList);
        log.info("存储数据库成功！");
    }
}
