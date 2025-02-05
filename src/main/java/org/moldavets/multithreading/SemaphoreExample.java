package org.moldavets.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);

        new Person("John", callBox);
        new Person("Katty", callBox);
        new Person("Oleg", callBox);
        new Person("Marina", callBox);
        new Person("Anna", callBox);
        new Person("Susan", callBox);
    }

}

class Person extends Thread {
    private String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    public void run() {
        try {
            System.out.println(name + " waiting for call...");
            callBox.acquire();
            System.out.println(name + " is talking right now<<");
            sleep(2000);
            System.out.println(name + " call finished!!!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            callBox.release();
        }
    }
}
