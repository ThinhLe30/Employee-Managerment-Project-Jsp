import com.ngthvu.quanlynhanvienproject.entity.Department;

import static org.junit.jupiter.api.Assertions.*;

class TestDepartmentsTest extends Department {

    public TestDepartmentsTest(Integer id, String name, String address, String phone_number, String description) {
        super(id, name, address, phone_number, description);
    }
}