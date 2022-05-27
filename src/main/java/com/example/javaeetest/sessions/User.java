package com.example.javaeetest.sessions;

public class User {
    private String name;
    private String surname;
    private String department;
    private String stackTechnologies;

    public User(String name, String surname, String department, String stackTechnologies) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.stackTechnologies = stackTechnologies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStackTechnologies() {
        return stackTechnologies;
    }

    public void setStackTechnologies(String stackTechnologies) {
        this.stackTechnologies = stackTechnologies;
    }
}
