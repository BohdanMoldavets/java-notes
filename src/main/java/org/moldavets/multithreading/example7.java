package org.moldavets.multithreading;

public class example7 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main started");
        Thread t1 = new Thread(new Worker());
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());
        System.out.println("Main finished");
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("Worker started");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Worker finished");
    }
}
