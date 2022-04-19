package com.hrm.user.handler;

import com.hrm.commons.benas.User;
import com.hrm.user.service.IUserService;
import com.hrm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model){
        User login_user = userService.findUserByLoginUser(user);
        // System.out.println(login_user);
        if (login_user != null){
            session.setAttribute("login_user",login_user);
            return "/jsp/main.jsp";
        }else {
            model.addAttribute("login_error","用户名或密码错误，请重新登录");
            return "index.jsp";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session,Model model){
        session.removeAttribute("login_user");
        model.addAttribute("login_error","退出成功，请重新登录！");
        return "/index.jsp";
    }

    @RequestMapping("/findUser")
    public String findUser(@RequestParam(defaultValue = "1") Integer pageIndex , User user , Model model){
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);

        Integer recordCount = userService.findUserCount(user);
        pageModel.setRecordCount(recordCount);

        List<User> users = userService.findUser(user,pageModel);

        model.addAttribute("pageModel",pageModel);
        model.addAttribute("users",users);
        model.addAttribute("user",user);

        // for (User u : users) {
        //     System.out.println(u);
        // }
        
        return "/jsp/user/user.jsp";
    }

    //用户修改
    @RequestMapping("/modifyUser")
    public String modifyUser(int pageIndex,User user,Model model,String flag){

        if (flag == null){
            user = userService.findUserById(user.getId());
            model.addAttribute("user",user);
            model.addAttribute("pageIndex",pageIndex);
            return "/jsp/user/showUpdateUser.jsp";
        }else {
            int rows = userService.modifyUser(user);
            if (rows >0 ){
                return "redirect:/user/findUser?pageIndex="+pageIndex;
            }else {
                model.addAttribute("fail","用户信息修改失败！");
                return "/jsp/fail.jsp";
            }
        }
    }

    //用户添加
    @RequestMapping("/addUser")
    public String addUser(User user,Model model){
        int rows = userService.addUser(user);
        if (rows > 0){
            PageModel pageModel = new PageModel();
            int recordCount = userService.findUserCount(null);
            pageModel.setRecordCount(recordCount);
            pageModel.getTotalSize();
            return "redirect:/user/findUser?pageIndex="+pageModel.getTotalSize();
        }else {
            model.addAttribute("fail","用户信息添加失败！");
            return "/jsp/fail.jsp";
        }
    }

    //用户删除
    @RequestMapping("/removeUser")
    public String removeUser(Integer[] ids,Model model,HttpSession session){
        //获取当前登录用户
        User login_user = (User) session.getAttribute("login_user");
        for (Integer id : ids) {
            if (login_user.getId() == id){
                model.addAttribute("fail","不能删除当前用户登录自身！");
                return "/jsp/fail.jsp";
            }
        }

        try {
            int rows = userService.removeUser(ids);
            if (rows == ids.length){
                return "/user/findUser";
            }else {
                model.addAttribute("fail","用户信息删除失败！");
                return "/jsp/fail.jsp";
            }
        }catch (DataIntegrityViolationException e){
            model.addAttribute("fail","当前用户发布公告或文档，请删除公告或文档后再删除用户！");
            return "/jsp/fail.jsp";
        }


    }

}
