package org.moldavets.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {
    public static void main(String[] args) throws InterruptedException {
        Lock ATM_LOCK = new ReentrantLock();
        new Employee("John Doe", ATM_LOCK);
        new Employee("Doe Jog", ATM_LOCK);
        new Employee("Jane Miss", ATM_LOCK);
        Thread.sleep(2000);
        new Employee("Michail Bobrov", ATM_LOCK);
        new Employee("Bohdan Molodec", ATM_LOCK);
    }
}

class Employee extends Thread {
    private String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    public void run() {
        if(lock.tryLock()) {
            try {
                System.out.println(name + " waiting..");
                lock.lock();
                System.out.println(name + " use ATM now");
                Thread.sleep(200);
                System.out.println(name + " end using ATM!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " doesn't want to use ATM!!!");
        }

    }
}