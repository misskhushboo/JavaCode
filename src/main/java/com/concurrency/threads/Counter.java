package com.concurrency.threads;

public class Counter {

    int count=0;
/*
    public synchronized void increment(){
        count++;
    }*/

    //Mutually exclusive. Multiple threads cannot access the shared resource at the same time.
    // Only one thread can access the shared resource at a time.
    public void increment(){
        synchronized (this){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}
