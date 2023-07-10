package com.java.code.streams;


import com.java.code.dto.Employees;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class EmployeeLivingInPune {

    public static void main(String[] args){
        EmployeeLivingInPune employeeLivingInPune=new EmployeeLivingInPune();
        employeeLivingInPune.problemStatementOne();
    }
    //Find all employees who live in ‘Pune’ city, sort them by their name, and print the names of employees.
    public void problemStatementOne(){
       List<Employees> employeeList= Arrays.asList(
                new Employees("A","Bangalore"),
                new Employees("B", "Delhi"),
                new Employees("C", "Mumbai"),
                new Employees("D", "Pune"),
                new Employees("E","Kolkotta"),
                new Employees("F","Gwalior"),
                new Employees("G","Jaipur"),
               new Employees("E", "Pune"),
               new Employees("A", "Pune")
        );
       employeeList.stream().filter(emp->emp.getCity().equals("Pune")).
               sorted(Comparator.comparing(Employees::getEmployeeFirstName)).forEach(System.out::println);
    }
}
