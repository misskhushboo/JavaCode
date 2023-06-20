package com.java.code.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.code.dto.Employees;

import java.io.IOException;
import java.util.List;

public class GetEmployeesData {

    public List<Employees> getEmployeesList(File jsonFile){
        List<Employees> employeesList= null;
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            employeesList = objectMapper.readValue(jsonFile,new TypeReference<List<Employees>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
