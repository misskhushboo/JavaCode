package com.concurrency.threads;

public class CustomThread extends java.lang.Thread {

    Counter counter;
    public CustomThread(Counter counter){
        this.counter=counter;
    }

    public void run(){
        System.out.println("Thread executed");
        for(int i=0; i<1000; i++){
            counter.increment();
        }
    }
}
