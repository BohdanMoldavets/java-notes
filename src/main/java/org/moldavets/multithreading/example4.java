package org.moldavets.multithreading;

public class example4 implements Runnable {
    @Override
    public void run() {
        System.out.println("Method run. Thread name=" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new example4());
        thread.start();
        System.out.println("Method main run. Thread name=" + Thread.currentThread().getName());

    }
}
