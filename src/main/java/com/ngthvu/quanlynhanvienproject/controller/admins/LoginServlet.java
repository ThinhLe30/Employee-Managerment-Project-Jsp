package com.ngthvu.quanlynhanvienproject.controller.admins;

import com.ngthvu.quanlynhanvienproject.entity.Admin;
import com.ngthvu.quanlynhanvienproject.service.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private AdminService adminService;
    public void init(){
        adminService = new AdminService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(adminService.isValidAdmin(username,password)){
            // success
            HttpSession session=request.getSession();
            Admin admin = adminService.findByUsernameAndPassword(username,password);
            System.out.println(admin);
            session.setAttribute("admin", admin);
            response.sendRedirect(request.getContextPath()+"/home");
        }
        else{
            // fail
            request.setAttribute("message", "Bad Credentials");
            request.getRequestDispatcher("view/login.jsp").forward(request,response);
        }
    }
}
