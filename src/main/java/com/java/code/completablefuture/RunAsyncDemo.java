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

public class RunAsyncDemo {

    public void saveEmployees(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper=new ObjectMapper();

        Executor executor= Executors.newFixedThreadPool(10);

        //Runnable in passed in runAsync method. So this is run() implementation.
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(
                ()->{
                  /*  List<Employees> employeesList= new GetEmployeesData().getEmployeesList(jsonFile);
                    return employeesList;

                    System.out.println("Thread : " + Thread.currentThread().getName());
                    employeesList.stream().forEach(System.out::println);
                    System.out.println(employeesList.size());*/
            }
        , executor);
        completableFuture.get(); //A blocking call
    }

    public static void main(String[] args){
        RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
        try {
            runAsyncDemo.saveEmployees(new File("employees.json"));
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
