package com.discussion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    public String name;
    public String departmentName;
    public int age;
    public int salary;
    public int empCode;

    public Employee(String name, int age){
        //this();
    }
    public Employee(String name, String departmentName, String age){
        //this()
    }
}
