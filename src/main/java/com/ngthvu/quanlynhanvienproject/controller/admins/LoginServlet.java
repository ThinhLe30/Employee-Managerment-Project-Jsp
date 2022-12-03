package com.ngthvu.quanlynhanvienproject.controller.admins;

import com.ngthvu.quanlynhanvienproject.bean.Admin;
import com.ngthvu.quanlynhanvienproject.bo.AdminBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private AdminBO adminBO;
    public void init(){
        adminBO = new AdminBO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(adminBO.isValidAdmin(username,password)){
            // success
            HttpSession session=request.getSession();
            Admin admin = adminBO.findByUsernameAndPassword(username,password);
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
