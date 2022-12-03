package com.ngthvu.quanlynhanvienproject.controller.employees;

import com.ngthvu.quanlynhanvienproject.bean.EmployeeView;
import com.ngthvu.quanlynhanvienproject.bo.EmployeeBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewEmployeeServlet", value = "/employees")
public class ViewEmployeeServlet extends HttpServlet {
    private EmployeeBO employeeBO;
    private static final Integer NUMBER_EMPLPOYEE_PER_PAGE = 8;
    @Override
    public void init(){
        employeeBO = new EmployeeBO();
    }
    // Controller, contact only with View and Service, do not linked Controller to Repository!
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNum =1; // page thu 1 // currentPage
        String keyword ="";
        String orderBy = "asc";
        String fieldName = "last_name";
        if (request.getParameter("pageNum") != null) {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        if (request.getParameter("keyword") != null) {
            keyword = request.getParameter("keyword");
        }
        if (request.getParameter("orderBy") != null) {
            orderBy = request.getParameter("orderBy");
        }
        if (request.getParameter("fieldName") != null) {
            fieldName = request.getParameter("fieldName");
        }
        Integer start = 0;
        if(pageNum > 1) {
            start = (pageNum-1)*NUMBER_EMPLPOYEE_PER_PAGE+1;
        }
        else{
            start = pageNum;
        }
        String reverseOrderBy = orderBy.equals("asc") ? "desc" : "asc";
        List<EmployeeView> employees = employeeBO.listByPage(start,NUMBER_EMPLPOYEE_PER_PAGE,keyword,fieldName,orderBy);
        Integer totalItems = employeeBO.countByKeyword(keyword); // countByKeyword();
        Integer totalPage = Math.round(totalItems/NUMBER_EMPLPOYEE_PER_PAGE)*NUMBER_EMPLPOYEE_PER_PAGE < totalItems ? Math.round(totalItems/NUMBER_EMPLPOYEE_PER_PAGE)+1 : Math.round(totalItems/NUMBER_EMPLPOYEE_PER_PAGE);
        //
        long startCount = (pageNum -1 ) * NUMBER_EMPLPOYEE_PER_PAGE +1;
        long endCount = startCount + NUMBER_EMPLPOYEE_PER_PAGE -1;
        if(endCount > totalItems)
        {
            endCount = totalItems;
        }
        request.setAttribute("startCount",startCount);
        request.setAttribute("endCount",endCount);
        request.setAttribute("keyword",keyword);
        request.setAttribute("orderBy",orderBy);
        request.setAttribute("reverseOrderBy",reverseOrderBy);
        request.setAttribute("fieldName",fieldName);
        request.setAttribute("pageNum",pageNum);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("employees",employees);
        request.getRequestDispatcher("/view/employees/employee_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
