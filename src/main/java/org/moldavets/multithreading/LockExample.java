package org.moldavets.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {

        Call call = new Call();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.discordCall();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.zoomCall();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Call {

    private static final Lock CALL_LOCK = new ReentrantLock();

    public void mobileCall() {
        CALL_LOCK.lock();
        try {
            System.out.println("Mobile call started");
            Thread.sleep(2500);
            System.out.println("Mobile call ended");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            CALL_LOCK.unlock();
        }
    }

    public void discordCall() {
        CALL_LOCK.lock();
        try {
            System.out.println("discord call started");
            Thread.sleep(3000);
            System.out.println("discord call ended");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            CALL_LOCK.unlock();
        }
    }

    public void zoomCall() {
        CALL_LOCK.lock();
        try {
            System.out.println("zoom call started");
            Thread.sleep(3500);
            System.out.println("zoom call ended");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            CALL_LOCK.unlock();
        }
    }

}