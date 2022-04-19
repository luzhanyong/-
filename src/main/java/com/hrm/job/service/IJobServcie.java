package com.hrm.job.service;

import com.hrm.commons.benas.Job;
import com.hrm.utils.PageModel;

import java.util.List;

public interface IJobServcie {

    List<Job> findJob(PageModel pageModel, String name);

    int findJobCount(String name);

    Job findJobById(Integer id);

    int modifyJob(Job job);

    int removeJob(Integer[] ids);

    int addJob(Job job);
}
