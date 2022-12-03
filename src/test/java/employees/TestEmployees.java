import com.ngthvu.quanlynhanvienproject.bean.Employee;
import com.ngthvu.quanlynhanvienproject.bean.EmployeeView;
import com.ngthvu.quanlynhanvienproject.exception.EmployeeNotFoundException;
import com.ngthvu.quanlynhanvienproject.bo.EmployeeBO;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEmployees {
    @Test
    void getAll() {
        EmployeeBO employeeBO = new EmployeeBO();
        List<Employee> employees = employeeBO.getAll();
        System.out.println(employees);
    }

    @Test
    void get() {
        try {
            EmployeeBO employeeBO = new EmployeeBO();
            Employee employee = employeeBO.get(3);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    void get1() {
        EmployeeBO employeeBO = new EmployeeBO();
        Employee employee = employeeBO.get("first_name", "Thinh");
    }
    @Test
    void search() {
        EmployeeBO employeeBO = new EmployeeBO();
        List<Employee> employees = employeeBO.search("Qu");
        System.out.println(employees);
    }

    @Test
    void delete() {
        try {
            EmployeeBO employeeBO = new EmployeeBO();
            employeeBO.delete(3);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getView() {
        try {
            EmployeeBO employeeBO = new EmployeeBO();
            EmployeeView employeeView = employeeBO.getView(4);
            System.out.println(employeeView.getFirstName());
            System.out.println(employeeView.getLastName());
            System.out.println(employeeView.getDepartmentName());
            System.out.println(employeeView.getBasicSalary());
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getView2() {
        try {
            EmployeeBO employeeBO = new EmployeeBO();
            EmployeeView employeeView = employeeBO.getView("first_name", "Thinh");
            System.out.println(employeeView.getFirstName());
            System.out.println(employeeView.getLastName());
            System.out.println(employeeView.getDepartmentName());
            System.out.println(employeeView.getBasicSalary());
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
