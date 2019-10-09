package com.ebran.api.model;

public class Department {
    private int deptId;
    private String deptName;

    public Department(int id, String deptName) {
        this.deptId = id;
        this.deptName = deptName;
    }

    public void setId(int id) {
        this.deptId = id;
    }

    public void setDeptName(String name) {
        this.deptName = name;
    }

    public int getId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }
}
