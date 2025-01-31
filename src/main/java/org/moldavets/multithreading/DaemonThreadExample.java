package org.moldavets.multithreading;

public class DaemonThreadExample {
    public static void main(String[] args) {
        System.out.println("Starting Main Thread");
        UserThread thread1 = new UserThread();
        thread1.setName("user_thread");
        DaemonThread thread2 = new DaemonThread();
        thread2.setName("daemon_thread");
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        System.out.println("Main Thread end");

    }
}

class UserThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon = " + isDaemon());
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                sleep(200);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DaemonThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon = " + isDaemon());
        for (int i = 1; i <= 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}