package org.moldavets.multithreading;

import org.moldavets.lambda.Car;

public class example11 {

    private static Object lock = new Object();

    public void mobileCall() {
        synchronized (lock) {
            System.out.println("mobileCall started");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("mobileCall ended");
        }
    }

    public void discordCall() {
        synchronized (lock) {
            System.out.println("discordCall started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("discordCall ended");
        }
    }

    public void whatsappCall() {
        synchronized (lock) {
            System.out.println("whatsappCall started");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("whatsappCall ended");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableMobileCall());
        Thread t2 = new Thread(new RunnableDiscordCall());
        Thread t3 = new Thread(new RunnableWhatsappCall());
        t1.start();
        t2.start();
        t3.start();
    }
}

class RunnableMobileCall implements Runnable {
    @Override
    public void run() {
        new example11().mobileCall();
    }
}

class RunnableDiscordCall implements Runnable {
    @Override
    public void run() {
        new example11().discordCall();
    }
}

class RunnableWhatsappCall implements Runnable {
    @Override
    public void run() {
        new example11().whatsappCall();
    }
}

