package com.ngthvu.quanlynhanvienproject.controller.admins;

import com.ngthvu.quanlynhanvienproject.entity.Admin;
import com.ngthvu.quanlynhanvienproject.exception.AdminNotFoundException;
import com.ngthvu.quanlynhanvienproject.bo.AdminBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditAdminServlet", value = "/admin/update")
public class EditAdminServlet extends HttpServlet {
    private AdminBO adminBO;
    public void init(){
        adminBO = new AdminBO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            Admin admin = adminBO.findById(id);
            request.setAttribute("admin",admin);
            request.setAttribute("pageTitle","Update Admin");
            request.getRequestDispatcher("/view/admins/admin_form.jsp").forward(request,response);
        } catch (AdminNotFoundException e) {
            request.getRequestDispatcher("/view/error/404.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
