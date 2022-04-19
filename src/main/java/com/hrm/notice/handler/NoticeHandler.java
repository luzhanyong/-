package com.hrm.notice.handler;

import com.hrm.commons.benas.Notice;
import com.hrm.commons.benas.User;
import com.hrm.notice.service.NoticeService;
import com.hrm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeHandler {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/findNotice")
    public String findNotice(Notice notice,@RequestParam(defaultValue = "1") int pageIndex, Model model){

        int recordCount = noticeService.findNoticeCount(notice);

        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        pageModel.setRecordCount(recordCount);

        List<Notice> notices = noticeService.findNotice(pageModel,notice);
        model.addAttribute("notice",notice);
        model.addAttribute("notices",notices);
        model.addAttribute("pageModel",pageModel);

        return "/jsp/notice/notice.jsp";
    }

    @RequestMapping("/modifyNotice")
    public String modifyNotice(String flag,int pageIndex,Notice notice,Model model){
        if (flag == null){
            notice = noticeService.findNoticeById(notice.getId());
            model.addAttribute("notice",notice);
            model.addAttribute("pageIndex",pageIndex);
            return "/jsp/notice/showUpdateNotice.jsp";
        }else {
            int rows = noticeService.modifyNotice(notice);
            if (rows > 0){
                return "redirect:/notice/findNotice?pageIndex="+pageIndex;
            }else {
                model.addAttribute("fail","公告信息修改失败！！！");
                return "/jsp/fail.jsp";
            }
        }

    }

    @RequestMapping("/previewNotice")
    public String previewNotice(int id,Model model){
        Notice notice = noticeService.findNoticeById(id);
        model.addAttribute("notice",notice);
        return "/jsp/notice/previewNotice.jsp";
    }

    @RequestMapping("/removeNotice")
    public String removeNotice(Integer[] ids,Model model){
        int rows = noticeService.removeNotice(ids);
        if (rows == ids.length){
            return "redirect:/notice/findNotice";
        }else {
            model.addAttribute("fail","删除失败！！！");
            return "/jsp/fail.jsp";
        }
    }

    @RequestMapping("/addNotice")
    public String addNotice(Notice notice, Model model, HttpSession session){
        //获取当前用户登录的id
        User login_user = (User) session.getAttribute("login_user");
        notice.setUser(login_user);

        int rows = noticeService.addNotice(notice);
        if (rows > 0 ) {
            PageModel pageModel = new PageModel();
            int recordCount = noticeService.findNoticeCount(null);
            pageModel.setRecordCount(recordCount);
            pageModel.getTotalSize();
            return "redirect:/notice/findNotice?pageIndex="+pageModel.getTotalSize();
        }else {
            model.addAttribute("fail","公告添加失败！！！");
            return "/jsp/fail.jsp";
        }
    }

}
