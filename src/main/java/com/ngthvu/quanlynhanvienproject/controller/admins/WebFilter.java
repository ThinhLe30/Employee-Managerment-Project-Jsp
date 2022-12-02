package com.ngthvu.quanlynhanvienproject.controller.admins;

import com.ngthvu.quanlynhanvienproject.entity.Admin;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WebFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String url = req.getRequestURL().toString();
        String[] actions = {"add","update","delete","admins"};
        boolean check = true;
        Admin admin = (Admin) session.getAttribute("admin");
        if(admin == null || session == null){
            for (String action : actions) {
                if(url.contains(action)){
                    check = false;
                }
            }
            if(check){
                res.sendRedirect(req.getContextPath()+"/login");
            }else{
                req.getRequestDispatcher("view/error/404.jsp").forward(request,response);
            }
        }
        else{
            chain.doFilter(request, response);
        }

    }
}
