package com.example.people;

public class Person {
    private int id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private int for_deletion;
    private int deletion_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFor_deletion() {
        return for_deletion;
    }

    public void setFor_deletion(int for_deletion) {
        this.for_deletion = for_deletion;
    }

    public int getDeletion_date() {
        return deletion_date;
    }

    public void setDeletion_date(int deletion_date) {
        this.deletion_date = deletion_date;
    }
}
