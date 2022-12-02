package com.ngthvu.quanlynhanvienproject.entity;

import java.util.Date;

public class EmployeeView {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;
    private String address;
    private Integer gender;
    private String phone;
    private String image;
    private String departmentName;
    private Float basicSalary;

    public EmployeeView(Integer id, String firstName, String lastName, String email, Date birthday, String address, Integer gender, String phone, String image, String departmentName, Float basicSalary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.image = image;
        this.departmentName = departmentName;
        this.basicSalary = basicSalary;
    }

    public EmployeeView() {
        this.id = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Float basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getInfo() {
        return this.getFirstName() + " " + this.getLastName()
                + "/" + this.getEmail() + "/" + this.getBirthday()
                + "/" + this.getAddress() + "/" + this.getGender()
                + "/" + this.getPhone() + "/" + this.getImage()
                + "/" + this.getDepartmentName() + "/" + this.getBasicSalary();
    }
}
