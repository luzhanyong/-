package com.hrm.job.handler;

import com.hrm.commons.benas.Job;
import com.hrm.job.service.IJobServcie;
import com.hrm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobHandler {

    @Autowired
    private IJobServcie jobServcie;

    @RequestMapping("/findJob")
    public String findJob(@RequestParam(defaultValue = "1") int pageIndex, String name, Model model){
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);

        List<Job> jobs = jobServcie.findJob(pageModel,name);

        int recordCount = jobServcie.findJobCount(name);
        pageModel.setRecordCount(recordCount);
        model.addAttribute("pageModel",pageModel);
        model.addAttribute("jobs",jobs);
        model.addAttribute("name",name);
        // for (Job job : jobs) {
        //     System.out.println(job);
        // }
        return "/jsp/job/job.jsp";
    }

    @RequestMapping("/findJobById")
    public String findJobById(Integer id,Integer pageIndex,Model model){
        Job job = jobServcie.findJobById(id);
        model.addAttribute("job",job);
        model.addAttribute("pageIndex",pageIndex);
        return "/jsp/job/showUpdateJob.jsp";
    }

    @RequestMapping("/modifyJob")
    @ResponseBody
    public String modifyJob(Job job){
        int rows = jobServcie.modifyJob(job);
        if (rows > 0){
            return "OK";
        }else {
            return "FAIL";
        }
    }

    @RequestMapping("/removeJob")
    @ResponseBody
    public String removeJob(Integer[] ids){
        try {
            int rows = jobServcie.removeJob(ids);
            if (rows == ids.length){
                return "OK";
            }else {
                return "FAIL";
            }
        }catch (DataIntegrityViolationException e){
            return "ERROR";
        }
    }

    @RequestMapping("/addJob")
    @ResponseBody
    public Object addJob(Job job){
        int rows = jobServcie.addJob(job);
        if (rows > 0){
            PageModel pageModel = new PageModel();
            int recordCount = jobServcie.findJobCount(null);
            pageModel.setRecordCount(recordCount);
            return pageModel.getTotalSize();
        }else {
            return "FAIL";
        }
    }

}
