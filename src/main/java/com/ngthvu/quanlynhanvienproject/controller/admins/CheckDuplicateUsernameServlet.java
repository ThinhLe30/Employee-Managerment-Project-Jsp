package com.ngthvu.quanlynhanvienproject.controller.admins;

import com.ngthvu.quanlynhanvienproject.bo.AdminBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckDuplicateUsernameServlet", value = "/checkDuplicateUsername")
public class CheckDuplicateUsernameServlet extends HttpServlet {
    private AdminBO adminBO;
    public void init(){
        adminBO = new AdminBO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            String result = adminBO.checkDuplicateUsername(id,username);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
