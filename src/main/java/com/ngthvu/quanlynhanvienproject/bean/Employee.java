package com.ngthvu.quanlynhanvienproject.bean;

import java.util.Date;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;
    private String address;
    private Integer gender;
    private String phone;
    private String image;
    private Integer id_department;
    private Integer id_salary;

    public Employee(Integer id, String firstName, String lastName, String email, Date birthday, String address,
                    Integer gender, String phone, String image, Integer id_department, Integer id_salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.image = image;
        this.id_department = id_department;
        this.id_salary = id_salary;
    }

    public Employee() {
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

    public Integer getId_department() {
        return id_department;
    }

    public void setId_department(Integer id_department) {
        this.id_department = id_department;
    }

    public Integer getId_salary() {
        return id_salary;
    }

    public void setId_salary(Integer id_salary) {
        this.id_salary = id_salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }
}