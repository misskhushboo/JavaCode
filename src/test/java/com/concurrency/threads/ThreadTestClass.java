package com.concurrency.threads;


public class ThreadTestClass {

    Counter counter = new Counter();

    public static void main(String[] args) {
        ThreadTestClass obj = new ThreadTestClass();
        obj.testCounter();
    }
    public void testCounter(){
        CustomThread t1=new CustomThread(counter);
        CustomThread t2=new CustomThread(counter);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());
    }
}
