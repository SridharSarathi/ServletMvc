package com.model;
import java.io.Serializable;

public class Employee {

    private int id;
    private String ename;
    private String password;
    private String email;
    private String country;

    public Employee() {
        System.out.println("Employee Constructor call");
    }

    public void setId(int id) {
          this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEname() {
        return ename;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}