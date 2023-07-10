package com.java.code.streams;

import com.java.code.dto.Employees;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NameFrequency {

    //Find the occurrence of names of employees from the List<Employee>,
    // and find the frequency of each name.

    public static void main(String[] args){
        new NameFrequency().problemStatement();
    }
    public void problemStatement(){
        List<Employees> employeeList= Arrays.asList(
                new Employees("A","Bangalore","male"),
                new Employees("B", "Delhi","male"),
                new Employees("A", "Mumbai","male"),
                new Employees("D", "Pune","female"),
                new Employees("E","Kolkotta","male"),
                new Employees("F","Gwalior","female"),
                new Employees("G","Jaipur","male"),
                new Employees("E", "Pune","female"),
                new Employees("A", "Pune","male")
        );
        //Collector<T, Map<K, List<T>> =Collectors.groupingBy(Function<T,K>),
        // group by operation performed on T elements based on Function operation, returning results in Map

        //1. How many similar name Employees exists? Count frequency of each name
       // The first argument is Employee::getEmployeeFirstName, which groups the input components depending on getEmployeeFirstName, and the second argument is Collectors.counting(), which counts the number of entries in each group.
        Map<String, Long> data=employeeList.stream().collect(Collectors.groupingBy(Employees::getEmployeeFirstName, Collectors.counting()));
        data.forEach((k,v)-> System.out.println(k+" "+v));

        //2. Grouping based on Employee name
       // Map<String, List<Employees>> employeesByAge = employeeList.stream()
                //.collect(Collectors.groupingBy(Employees::getEmployeeFirstName));

        //3.
        //Map<String, Integer> result = employeeList.stream()
        //        .collect(Collectors.groupingBy(Employees::getEmployeeFirstName, Collectors.summingInt(Employees::getQty)));

      //4. How many employees are there?
        long count = employeeList.stream().count();
        System.out.println("Employees count using count() : " + count);

        long count1 = employeeList.stream().collect(Collectors.counting());
        System.out.println("Employees Count using Collectors.counting() : " + count1);

        //5. Get name of all distinct employees. If Rahul exists twice, print it once.
        List<String> departments = employeeList.stream().map(Employees::getEmployeeFirstName).distinct().collect(Collectors.toList());
        departments.forEach(emp-> System.out.println(emp));

        //6. Find the average salary of the male and female employee
        Map<String, Double> averageSalaryGenderWise = employeeList.stream().collect(Collectors.groupingBy(Employees::getGender, Collectors.averagingDouble(Employees::getSalary)));
        averageSalaryGenderWise.entrySet().stream().forEach(entry-> System.out.println(entry.getKey()+" average salary="+ entry.getValue()));
        //System.out.println("Average salary of male and female employees : "+averageSalaryGenderWise);
    }
}
