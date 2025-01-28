package org.moldavets.multithreading;

public class example {
    public static void main(String[] args) {

        thread1 thread1 = new thread1();
        thread2 thread2 = new thread2();
        thread1.start();
        thread2.start();

    }
}

class thread1 extends Thread {
    public void run() {
        for(int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}
class thread2 extends Thread {
    public void run() {
        for(int i = 1000; i >= 1; i--) {
            System.out.println(i);
        }
    }
}