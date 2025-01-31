package org.moldavets.multithreading;

public class DeadLockExample {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread10 = new Thread10();
        Thread thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
}

class Thread10 extends Thread {
    public void run() {
        System.out.println("Thread10: try to catch  of object lock1");
        synchronized (DeadLockExample.lock1) {
            System.out.println("Thread10: caught monitor of object lock1");
            System.out.println("Thread10: try to catch  of object lock2");
            synchronized (DeadLockExample.lock2) {
                System.out.println("Thread10: caught monitors of objects lock1 and lock2");
            }
        }
    }
}

class Thread20 extends Thread {
    public void run() {
        System.out.println("Thread20: try to catch  of object lock2");
        synchronized (DeadLockExample.lock2) {
            System.out.println("Thread20: caught monitor of object lock2");
            System.out.println("Thread20: try to catch  of object lock1");
            synchronized (DeadLockExample.lock1) {
                System.out.println("Thread20: caught monitors of objects lock1 and lock2");
            }
        }
    }
}
