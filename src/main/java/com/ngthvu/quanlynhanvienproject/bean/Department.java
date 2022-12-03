package com.ngthvu.quanlynhanvienproject.bean;

public class Department {
    private Integer id;
    private String name;
    private String address;
    private String phone_number;
    private String description;

    public Department(Integer id, String name, String address, String phone_number, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.description = description;
    }

    public Department() {
        this.id = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id +
                ", name=" + name +
                ", address=" + address +
                ", phone_number=" + phone_number +
                ", description=" + description +
                '}';
    }
}
