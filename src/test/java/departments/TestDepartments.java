//import com.ngthvu.quanlynhanvienproject.entity.Department;
//import com.ngthvu.quanlynhanvienproject.exception.DepartmentNotFoundException;
//import com.ngthvu.quanlynhanvienproject.service.DepartmentService;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//public class TestDepartments {
//    @Test
//    void getAll() {
//        List<Department> departments = new DepartmentService().getAll();
//        System.out.println(departments);
//    }
//    @Test
//    void get() throws DepartmentNotFoundException {
//        Department department = new DepartmentService().get(1);
//        Department department2 = new DepartmentService().get("name", "Production");
//        System.out.println(department);
//        System.out.println(department2);
//    }
//
//    @Test
//    void add() {
//        Department department = new Department();
//        department.setName("Test");
//        department.setAddress("Test");
//        department.setPhone("Test");
//        department.setDescription("Test");
//        try {
//            new DepartmentService().add(department);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void update() {
//        Department department = new Department();
//        department.setId(7);
//        department.setName("Test11");
//        department.setAddress("Test11");
//        department.setPhone("Test11");
//        department.setDescription("Test11");
//        try {
//            new DepartmentService().update(department);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void delete() {
//        try {
//            new DepartmentService().delete(1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void search() {
//        List<Department> departments = new DepartmentService().search("Acc");
//        System.out.println(departments);
//    }
//}
