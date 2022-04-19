package com.hrm.toview.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toView")
public class ToViewHandler {

    @RequestMapping("/schoolLeader")
    public String toschoolLeader(){
        return "/jsp/leader/schoolLeader.jsp";
    }

    @RequestMapping("/schoolchuLeader")
    public String toschoolchuLeader(){
        return "/jsp/leader/schoolchuLeader.jsp";
    }

    @RequestMapping("/schoolkeLeader")
    public String toschoolkeLeader(){
        return "/jsp/leader/schoolkeLeader.jsp";
    }

    @RequestMapping("/addSchoolLeader")
    public String toAddSchoolLeader(){
        return "/jsp/leader/addSchoolLeader.jsp";
    }

    @RequestMapping("/addSchoolchuLeader")
    public String toAddSchoolchuLeader(){
        return "/jsp/leader/addSchoolchuLeader.jsp";
    }

    @RequestMapping("/addSchoolkeLeader")
    public String toAddSchoolkeLeader(){
        return "/jsp/leader/addSchoolkeLeader.jsp";
    }
}

