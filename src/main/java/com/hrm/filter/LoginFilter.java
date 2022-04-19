package com.hrm.filter;

import com.hrm.commons.benas.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    String[] IG_URI= {"/index.jsp","/loginForm.jsp","/login","/",".css",".js",".jpg"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //强制类型转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        for (String s : IG_URI) {
            if (requestURI.endsWith(s)){
                //直接放行
                filterChain.doFilter(request,response);
                return;
            }
        }
        //获取用户登录信息
        User login_user = (User) request.getSession().getAttribute("login_user");
        //用户已登录
        if (login_user != null){
            filterChain.doFilter(request,response);
        }
        else{
            request.setAttribute("login_error","您还未登录！！！");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }
}
