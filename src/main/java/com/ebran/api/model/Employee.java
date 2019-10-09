package com.ebran.api.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {

    private int id;
    private String name;
    private String email;
    private String address;

    private ArrayList<String> hobbies;

    @JsonUnwrapped
    private Department department;

    public Employee() {}

    public Employee(int id, String name, String email, String address, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.department = department;

        hobbies = new ArrayList<>();
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
