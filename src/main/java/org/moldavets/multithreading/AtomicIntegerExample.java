package org.moldavets.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void increment() {
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RunnableAtomic());
        Thread t2 = new Thread(new RunnableAtomic());

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(atomicInteger.get());
    }

}

class RunnableAtomic implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            AtomicIntegerExample.increment();
        }
    }
}