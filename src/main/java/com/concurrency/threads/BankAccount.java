package com.concurrency.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 2000;
    private final Lock lock=new ReentrantLock();

    public synchronized void withdraw(int amount){
        if(balance >= amount){
            System.out.println("Processing withdraw of "+amount+" Thread="+ Thread.currentThread().getName());
            balance = balance - amount;
            System.out.println("Withdrawn "+amount+" | Remaining Balance "+balance);
        }
        else
            System.out.println("Insufficient Balance");
    }

   public void withdrawAmount(int amount){

       try {
           if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){

                   if(balance >= amount){
                       System.out.println("Processing withdraw of "+amount+" Thread="+ Thread.currentThread().getName());
                       balance = balance - amount;
                       try {
                           Thread.sleep(3000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println("Withdrawn "+amount+" | Remaining Balance "+balance);
                       lock.unlock();
                   }
                   else
                       System.out.println("Insufficient Balance");

           }
          else
              System.out.println("Couldn't get the lock");
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }
}

class Customer{
    BankAccount bankAccount;
    int amount;

    public Customer(BankAccount bankAccount, int amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Customer c1 = new Customer(bankAccount, 700);
        Customer c2 = new Customer(bankAccount, 500);
        Thread t1 = new Thread(() -> c1.bankAccount.withdraw(c1.amount));
        //this thread will not wait for the lock and it will print "Insufficient Balance"
        // because the balance is 300 after the first withdraw
        Thread t2 = new Thread(() -> c2.bankAccount.withdraw(c2.amount));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Thread1 will get the lock and acquire the lock but will sleep for 3 seconds
        Thread t3 = new Thread(() -> c1.bankAccount.withdrawAmount(c1.amount));
        //this thread will wait for 1 second to acquire the lock and then it will give up and print "Couldn't get the lock"
        Thread t4 = new Thread(() -> c2.bankAccount.withdrawAmount(c2.amount));
        t3.start();
        t4.start();;

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
