package com.java.code.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employees {
    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String email;
    private String phonenumber;
    private String gender;
    private String rating;

    private String city;

    private int Salary;

    public Employees(String name, String city){
            this.employeeFirstName=name;
            this.city=city;
    }
    public Employees(String name, String city, String gender){
        this.employeeFirstName=name;
        this.city=city;
        this.gender=gender;
    }
}
