package com.example.personel;

import java.util.HashMap;

public class Department {
    private int departments_id;
    private int manager_id;
    private String department_title;

    public Department() {}
    public Department(HashMap<String, Object> department_data) {
        this.departments_id = (int) department_data.getOrDefault("departments_id", 0);
        this.manager_id = (int) department_data.getOrDefault("manager_id", 0);
        this.department_title = (String) department_data.getOrDefault("department_title", "");
    }

    public int getDepartments_id() {
        return departments_id;
    }

    public void setDepartments_id(int departments_id) {
        this.departments_id = departments_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getDepartment_title() {
        return department_title;
    }

    public void setDepartment_title(String department_title) {
        this.department_title = department_title;
    }
}
