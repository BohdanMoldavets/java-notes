package org.moldavets.multithreading;

public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");

        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        thread.join();
        System.out.println("Main end");
    }
}

class InterruptedThread extends Thread {

    private double sqrtSum = 0;

    public void run() {
        for (int i = 1; i <= 1000000; i++) {
            if(isInterrupted()) {
                System.out.println("Thread interrupt now");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
        }
        System.out.println(sqrtSum);
    }
}