package org.moldavets.multithreading;

public class volatileExample extends Thread {
    volatile boolean boolMark = true;

    public void run() {
        long count = 0;

        while (boolMark) {
            count++;
        }
        System.out.println("Loop is finished, count = " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        volatileExample thread = new volatileExample();
        thread.start();
        Thread.sleep(3000);
        System.out.println("3 seconds left, it is time to wake up!");
        thread.boolMark = false;
        thread.join();
        System.out.println("Main thread finished");

    }
}
