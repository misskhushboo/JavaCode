package com.java.code.completablefuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.code.dto.Employees;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RunAsyncDemo {

    public void saveEmployees(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper=new ObjectMapper();

        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(new Runnable(){
            public void run(){
                List<Employees> employeesList= null;
                try {
                    employeesList = objectMapper.readValue(jsonFile,new TypeReference<List<Employees>>() {});
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread : " + Thread.currentThread().getName());
                employeesList.stream().forEach(System.out::println);
                System.out.println(employeesList.size());
            }
        });
        completableFuture.get();
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
