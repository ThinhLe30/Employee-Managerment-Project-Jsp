package com.ngthvu.quanlynhanvienproject.repository;

import com.ngthvu.quanlynhanvienproject.entity.Department;
import com.ngthvu.quanlynhanvienproject.entity.Employee;
import com.ngthvu.quanlynhanvienproject.entity.EmployeeView;
import com.ngthvu.quanlynhanvienproject.entity.Salary;
import com.ngthvu.quanlynhanvienproject.util.DbHelper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    // represent DAO, contact with database in MySql,return Entity or List of Entity
    // do not contact from Controller to Repository
    // have to go through Service to Repository
    private final DbHelper dbHelper;
    private final DepartmentRepository departmentRepository;
    private final SalaryRepository salaryRepository;
    private static final String GET_ALL_EMPLOYEES =
            "select * from employees";

    private static final String GET_EMPLOYEE =
            "select * from employees where key = ?";

    private static final String DELETE_EMPLOYEE = "delete from employees where id = ?";

    private static final String INSERT_EMPLOYEE = "INSERT INTO employees" +
            "(first_name,last_name,email,birthday,address,gender,phone_number,image,id_department,id_level_salary) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final String  UPDATE_EMPLOYEE = "UPDATE employees " +
            "SET first_name = ?, last_name = ?, email = ?, birthday = ?, address = ?," +
            "gender = ?, phone_number = ?, image = ?, id_department = ?," +
            "id_level_salary = ?  WHERE id = ?";

    private static final String SEARCH_EMPLOYEE =
            "select * from employees inner join (select id as depID, name from departments) dep on id_department = depID" +
            " inner join (select id as salID,basic_salary from level_salaries) sal on id_level_salary = salID WHERE " +
            "concat (first_name, ' ', last_name, ' ', email, ' ', birthday," +
            "' ',address, ' ', phone_number, ' ', name, ' ', basic_salary) like ?";
    private static final String COUNT_BY_KEYWORD =
            "select count(*) as count from employees" +
                    " left join (select id as depID, name from departments) dep on id_department = depID " +
                    " left join (select id as salID,basic_salary from level_salaries) sal on id_level_salary = salID" +
                    " WHERE concat (first_name, ' ', last_name, ' ', email, ' ', birthday,' ',address, ' '," +
                    " phone_number, ' ', COALESCE (name, ''), ' ', COALESCE (basic_salary, ''))" +
                    " like concat( '%',?,'%')";
    private static final String LIST_BY_PAGE =
            "select * from employees" +
                    " left join (select id as depID, name from departments) dep on id_department = depID " +
                    " left join (select id as salID,basic_salary from level_salaries) sal on id_level_salary = salID" +
                    " WHERE concat (first_name, ' ', last_name, ' ', email, ' ', birthday,' ',address, ' '," +
                    " phone_number, ' ', COALESCE (name, ''), ' ', COALESCE (basic_salary, ''))" +
                    " like concat( '%',?,'%')";

    private static final String CHECK_DUPLICATE_EMAIL =
            "select count(*) as count from employees where email = ?";

    private static final String CHECK_DUPLICATE_PHONE =
            "select count(*) as count from employees where phone_number = ?";

    public EmployeeRepository() {
        dbHelper = new DbHelper();
        departmentRepository = new DepartmentRepository();
        salaryRepository = new SalaryRepository();
    }

    public Integer countByKeyword(String keyword) {
        Integer count = 0;
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(COUNT_BY_KEYWORD);
            preparedStatement.setString(1,keyword);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<EmployeeView> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy){
        List<EmployeeView> employeeViews = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(LIST_BY_PAGE + " order by "+fieldName+" "+orderBy+" limit ?,?");
            preparedStatement.setString(1,keyword);
            preparedStatement.setInt(2,start-1);
            preparedStatement.setInt(3,numberPerPage);
            ResultSet rs = preparedStatement.executeQuery();
            String departmentName = null;
            Float basic_salary = null;
            while (rs.next()) {
                if(rs.getString("id_department") == null){
                    departmentName = "None";
                }else{
                    departmentName = rs.getString("name");
                }
                if(rs.getString("id_level_salary") == null){
                    basic_salary = 0F;
                }else{
                    basic_salary = rs.getFloat("basic_salary");
                }
                employeeViews.add(
                        new EmployeeView(
                                rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getDate("birthday"),
                                rs.getString("address"),
                                rs.getInt("gender"),
                                rs.getString("phone_number"),
                                rs.getString("image"),
                                departmentName,
                                basic_salary
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeViews;
    }

    public ArrayList<Employee> getAll() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(GET_ALL_EMPLOYEES);
            listEmployee(employees, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

//    public ArrayList<EmployeeView> getAllView() {
//        ArrayList<EmployeeView> employeesView = new ArrayList<EmployeeView>();
//        try {
//            PreparedStatement ps = dbHelper.getConnection().prepareStatement(GET_ALL_EMPLOYEES);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                employeesView.add(
//                        new EmployeeView(
//                                rs.getInt("id"),
//                                rs.getString("first_name"),
//                                rs.getString("last_name"),
//                                rs.getString("email"),
//                                rs.getDate("birthday"),
//                                rs.getString("address"),
//                                rs.getInt("gender"),
//                                rs.getString("phone_number"),
//                                rs.getString("image"),
//                                departmentRepository.get(rs.getInt("id_department")).getName(),
//                                salaryRepository.findById(rs.getInt("id_level_salary")).getBasicSalary()
//                        )
//                );
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return employeesView;
//    }

    public ArrayList<Employee> search(String keyword) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(SEARCH_EMPLOYEE);
            ps.setString(1, "%" + keyword + "%");
            listEmployee(employees, ps);
        } catch (Exception e) {
                e.printStackTrace();
        }
        return employees;
    }

    private void listEmployee(ArrayList<Employee> employees, PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            employees.add(
                    new Employee(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getDate("birthday"),
                            rs.getString("address"),
                            rs.getInt("gender"),
                            rs.getString("phone_number"),
                            rs.getString("image"),
                            rs.getInt("id_department"),
                            rs.getInt("id_level_salary")
                    )
            );

        }
    }

    //Get employeeView by ID
    public EmployeeView getView(Integer id) {
        EmployeeView employeeView = new EmployeeView();
        try {
            String GET_EMPLOYEE_ID = GET_EMPLOYEE.replace("key", "id");
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(GET_EMPLOYEE_ID);
            ps.setInt(1, id);
            setEmployeeView(employeeView, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeView;
    }

    //Get employee by ID
    public Employee get(Integer id) {
        Employee employee = new Employee();
        try {
            String GET_EMPLOYEE_ID = GET_EMPLOYEE.replace("key", "id");
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(GET_EMPLOYEE_ID);
            ps.setInt(1, id);
            setEmployee(employee, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    //Get employee by type
    public Employee get(String type, String value) {
        Employee employee = new Employee();
        String GET_EMPLOYEE_TYPE = GET_EMPLOYEE.replace("key", type);
        System.out.println(GET_EMPLOYEE_TYPE);
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(GET_EMPLOYEE_TYPE);
            ps.setString(1, value);
            setEmployee(employee, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    //Get EmployeeView by type
    public EmployeeView getView(String type, String value) {
        EmployeeView employeeView = new EmployeeView();
        String GET_EMPLOYEE_TYPE = GET_EMPLOYEE.replace("key", type);
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(GET_EMPLOYEE_TYPE);
            ps.setString(1, value);
            setEmployeeView(employeeView, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeView;
    }

    //Add new employee
    public void add(Employee employee) {
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(INSERT_EMPLOYEE);
            addUpdate(employee, ps);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Employee employee) {
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(UPDATE_EMPLOYEE);
            addUpdate(employee, ps);
            ps.setInt(11, employee.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addUpdate(Employee employee, PreparedStatement ps) throws SQLException {
        ps.setString(1, employee.getFirstName());
        ps.setString(2, employee.getLastName());
        ps.setString(3, employee.getEmail());
        ps.setDate(4, (Date) employee.getBirthday());
        ps.setString(5, employee.getAddress());
        ps.setInt(6, employee.getGender());
        ps.setString(7, employee.getPhone());
        ps.setString(8, employee.getImage());
        if(employee.getId_department() == 0){
            ps.setNull(9,java.sql.Types.INTEGER);
        }
        else{
            ps.setInt(9, employee.getId_department());
        }
        if(employee.getId_salary() == 0){
            ps.setNull(10,java.sql.Types.INTEGER);
        }
        else{
            ps.setInt(10, employee.getId_salary());
        }

    }

    public void delete(Integer id) {
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(DELETE_EMPLOYEE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEmployee(Employee employee, PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            employee.setId(rs.getInt("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            employee.setBirthday(rs.getDate("birthday"));
            employee.setAddress(rs.getString("address"));
            employee.setGender(rs.getInt("gender"));
            employee.setPhone(rs.getString("phone_number"));
            employee.setImage(rs.getString("image"));
            employee.setId_department(rs.getInt("id_department"));
            employee.setId_salary(rs.getInt("id_level_salary"));
        }
    }

    public void setEmployeeView(EmployeeView employeeView, PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        String departmentName = null;
        Float basic_salary = null;
        while (rs.next()) {
            if(rs.getString("id_department") == null){
                departmentName = "None";
            }else{
                departmentName = departmentRepository.get(rs.getInt("id_department")).getName();
            }
            if(rs.getString("id_level_salary") == null){
                basic_salary = 0F;
            }else{
                basic_salary = salaryRepository.findById(rs.getInt("id_level_salary")).getBasicSalary();
            }
            employeeView.setId(rs.getInt("id"));
            employeeView.setFirstName(rs.getString("first_name"));
            employeeView.setLastName(rs.getString("last_name"));
            employeeView.setEmail(rs.getString("email"));
            employeeView.setBirthday(rs.getDate("birthday"));
            employeeView.setAddress(rs.getString("address"));
            employeeView.setGender(rs.getInt("gender"));
            employeeView.setPhone(rs.getString("phone_number"));
            employeeView.setImage(rs.getString("image"));
            employeeView.setDepartmentName(departmentName);
            employeeView.setBasicSalary(basic_salary);
        }
    }

    public String checkDuplicateEmail(Integer id, String email) {
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(CHECK_DUPLICATE_EMAIL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getInt("count") > 0) {
                    //add
                    if(id == 0) {
                        return "Duplicate";
                    } else {
                        Employee employee = get(id);
                        if(!employee.getEmail().equals(email)) {
                            return "Duplicate";
                        }
                    }
                } else {
                    return "OK";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }

    public String checkDuplicatePhone(Integer id, String phone) {
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(CHECK_DUPLICATE_PHONE);
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getInt("count") > 0) {
                    //add
                    if(id == 0) {
                        return "Duplicate";
                    } else {
                        Employee employee = get(id);
                        if(!employee.getPhone().equals(phone)) {
                            return "Duplicate";
                        }
                    }
                } else {
                    return "OK";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }

    public String checkDuplicate(Integer id, String email, String phone) {
        try {
            String checkEmail = checkDuplicateEmail(id, email);
            String checkPhone = checkDuplicatePhone(id, phone);
            if(checkEmail.equals("Duplicate") && checkPhone.equals("Duplicate")) {
                return "Duplicate Email and Phone";
            } else if(checkEmail.equals("Duplicate")) {
                return "Duplicate Email";
            } else if(checkPhone.equals("Duplicate")) {
                return "Duplicate Phone";
            } else {
                return "OK";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }
}
