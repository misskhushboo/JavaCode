package com.java.code.completablefuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.code.database.GetEmployeesData;
import com.java.code.dto.Employees;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {


    public List<Employees> getEmployeesFromFile(File jsonFile){

          /*Executor executor= Executors.newFixedThreadPool(10);

      CompletableFuture<List<Employees>> completableFuture=CompletableFuture.supplyAsync(
                ()->{
                    List<Employees> employeesList= new GetEmployeesData().getEmployeesList(jsonFile);
                    return employeesList;
                },executor);
        try {
            return completableFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }*/
        return null;
    }
    public static void main(String[] args){
        //SupplyAsyncDemo supplyAsyncDemo = new SupplyAsyncDemo();
        //List<Employees> employeesList=supplyAsyncDemo.getEmployeesFromFile(new File("employees.json"));
        //employeesList.stream().forEach(System.out::println);
    }
}
