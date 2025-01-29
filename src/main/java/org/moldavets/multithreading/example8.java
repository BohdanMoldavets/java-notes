package org.moldavets.multithreading;

public class example8 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable2());
        Thread t2 = new Thread(new MyRunnable2());
        Thread t3 = new Thread(new MyRunnable2());
        t1.start();
        t2.start();
        t3.start();
    }
}

class Count {
    volatile static int counter = 0;
}

class MyRunnable2 implements Runnable {
        
    public synchronized void increment() {
        Count.counter++;
        System.out.print(Count.counter + " ");
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}
