package com.ngthvu.quanlynhanvienproject.controller.employees;

import com.ngthvu.quanlynhanvienproject.entity.Employee;
import com.ngthvu.quanlynhanvienproject.exception.EmployeeNotFoundException;
import com.ngthvu.quanlynhanvienproject.bo.EmployeeBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(name = "SaveEmployeeServlet", value = "/employee/save")
@MultipartConfig()
//        location = "D:\\3th year\\5th sem\\LapTrinhMang\\BaiTapLon\\Employees-Management-Web-App\\src\\main\\webapp\\view\\uploads",
//        fileSizeThreshold=1024*1024*2, // 2MB
//        maxFileSize=1024*1024*10,      // 10MB
//        maxRequestSize=1024*1024*50)
public class SaveEmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO;

    @Override
    public void init() throws ServletException {
        employeeBO = new EmployeeBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(request.getParameter("id")));
        employee.setFirstName(request.getParameter("firstname"));
        employee.setLastName(request.getParameter("lastname"));
        employee.setEmail(request.getParameter("email"));
        employee.setBirthday(java.sql.Date.valueOf(request.getParameter("birthday")));
        employee.setAddress(request.getParameter("address"));
        employee.setGender(Integer.parseInt(request.getParameter("gender")));
        employee.setPhone(request.getParameter("phone"));
        employee.setId_department(Integer.parseInt(request.getParameter("id_department")));
        employee.setId_salary(Integer.parseInt(request.getParameter("id_salary")));

        if( request.getPart("image").getHeader("content-disposition").split("=")[2].equals("\"\"")) {
            if (Integer.parseInt(request.getParameter("id")) == 0) {
                employee.setImage("default.jpg");
            } else {
                employee.setImage(request.getParameter("image_name"));
            }
        } else {
                String uploadFolder = request.getServletContext().getRealPath("/uploads-img");
                Path uploadPath = Paths.get(uploadFolder);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectory(uploadPath);
                }
                Part imagePart = request.getPart("image");
                String imageName = getFileName(imagePart, request.getParameter("phone"));
                imagePart.write(Paths.get(uploadPath.toString(), imageName).toString());
                employee.setImage(imageName);
        }

        try {
            employeeBO.save(employee);
            response.sendRedirect(request.getContextPath()+"/employees");
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("500.jsp");
        }
    }

    private String getFileName(Part part,String phone) {
        String contentDisposition= part.getHeader("content-disposition");
        if(!contentDisposition.contains("filename")) {
            return null;
        }
        String fileType = contentDisposition.split("\\.")[1].replace("\"", "");
        return phone + "." + fileType;
    }
}











