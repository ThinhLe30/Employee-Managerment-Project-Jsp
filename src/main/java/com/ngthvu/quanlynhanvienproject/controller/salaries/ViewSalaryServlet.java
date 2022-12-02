package com.ngthvu.quanlynhanvienproject.controller.salaries;

import com.ngthvu.quanlynhanvienproject.entity.Salary;
import com.ngthvu.quanlynhanvienproject.service.SalaryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewSalaryServlet", value = "/salaries")
public class ViewSalaryServlet extends HttpServlet {
    private SalaryService salaryService;
    public void init(){
        salaryService = new SalaryService();
    }
    private static final Integer NUMBER_SALARY_PER_PAGE = 8;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNum =1; // page thu 1 // currentPage
        String keyword ="";
        String orderBy = "asc";
        String fieldName = "basic_salary";
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
            start = (pageNum-1)*NUMBER_SALARY_PER_PAGE+1;
        }
        else{
            start = pageNum;
        }
        String reverseOrderBy = orderBy.equals("asc") ? "desc" : "asc";
        List<Salary> salaries = salaryService.listByPage(start,NUMBER_SALARY_PER_PAGE,keyword,fieldName,orderBy);
        Integer totalItems = salaryService.countByKeyword(keyword); // countByKeyword();
        Integer totalPage = Math.round(totalItems/NUMBER_SALARY_PER_PAGE)*NUMBER_SALARY_PER_PAGE < totalItems ? Math.round(totalItems/NUMBER_SALARY_PER_PAGE)+1 : Math.round(totalItems/NUMBER_SALARY_PER_PAGE);
        //
        long startCount = (pageNum -1 ) * NUMBER_SALARY_PER_PAGE +1;
        long endCount = startCount + NUMBER_SALARY_PER_PAGE -1;
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
        request.setAttribute("salaries",salaries);
        request.getRequestDispatcher("/view/salaries/salary_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
