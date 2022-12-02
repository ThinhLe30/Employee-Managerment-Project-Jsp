import com.ngthvu.quanlynhanvienproject.entity.Employee;
import com.ngthvu.quanlynhanvienproject.entity.EmployeeView;
import com.ngthvu.quanlynhanvienproject.exception.EmployeeNotFoundException;
import com.ngthvu.quanlynhanvienproject.service.EmployeeService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEmployees {
    @Test
    void getAll() {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.getAll();
        System.out.println(employees);
    }

    @Test
    void get() {
        try {
            EmployeeService employeeService = new EmployeeService();
            Employee employee = employeeService.get(3);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    void get1() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.get("first_name", "Thinh");
    }
    @Test
    void search() {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.search("Qu");
        System.out.println(employees);
    }

    @Test
    void delete() {
        try {
            EmployeeService employeeService = new EmployeeService();
            employeeService.delete(3);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getView() {
        try {
            EmployeeService employeeService = new EmployeeService();
            EmployeeView employeeView = employeeService.getView(4);
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
            EmployeeService employeeService = new EmployeeService();
            EmployeeView employeeView = employeeService.getView("first_name", "Thinh");
            System.out.println(employeeView.getFirstName());
            System.out.println(employeeView.getLastName());
            System.out.println(employeeView.getDepartmentName());
            System.out.println(employeeView.getBasicSalary());
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
