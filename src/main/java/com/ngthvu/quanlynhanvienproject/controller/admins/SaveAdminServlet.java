package com.ngthvu.quanlynhanvienproject.controller.admins;

import com.ngthvu.quanlynhanvienproject.bean.Admin;
import com.ngthvu.quanlynhanvienproject.bo.AdminBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveAdminServlet", value = "/admin/save")
public class SaveAdminServlet extends HttpServlet {
    private AdminBO adminBO;
    public void init(){
        adminBO = new AdminBO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String phone = request.getParameter("phone");

        Admin admin = new Admin(id,username,password,first_name,last_name,phone);
        adminBO.save(admin);
        response.sendRedirect(request.getContextPath()+"/admins");
    }
}
