package org.moldavets.multithreading;

public class example10 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable3 myRunnable3 = new MyRunnable3();
        Thread t1 = new Thread(myRunnable3);
        Thread t2 = new Thread(myRunnable3);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class Counter1 {
    static volatile int counter = 0;
}

class MyRunnable3 implements Runnable {

    public void increment() {
        System.out.println("Hi!");
        synchronized (this) {
            Counter1.counter++;
            System.out.println(Counter1.counter);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}