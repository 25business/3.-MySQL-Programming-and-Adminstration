package com.example.personel;
import java.util.HashMap;

public class Employee {
    private int employees_id;
    private String first_name;
    private String last_name;
    private String email;

    public Employee() {}

    public Employee(HashMap<String, Object> employee_data) {
        this.employees_id = (int) employee_data.getOrDefault("employees_id", 0);
        this.first_name = (String) employee_data.getOrDefault("first_name", "");
        this.last_name = (String) employee_data.getOrDefault("last_name", "");
        this.email = (String) employee_data.getOrDefault("email", "");
    }

    public int getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return String.format("""
                ID: %d
                First name: %s
                Last name: %s
                Email: %s
                """, employees_id, first_name, last_name, email);
    }
}
