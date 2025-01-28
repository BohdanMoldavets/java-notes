package org.moldavets.multithreading;

public class example2 implements Runnable {

    public void run() {
        for(int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new example2());
        t1.start();

        for(int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }

    }
}


