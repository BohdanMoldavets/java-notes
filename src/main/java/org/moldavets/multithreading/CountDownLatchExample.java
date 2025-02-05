package org.moldavets.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void marketStuffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market stuff came to work");
        countDownLatch.countDown();
        System.out.println("CountDownLatch = " + countDownLatch.getCount());
    }

    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready so let's open the market");
        countDownLatch.countDown();
        System.out.println("CountDownLatch = " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is opened!");
        countDownLatch.countDown();
        System.out.println("CountDownLatch = " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        new Friend("John",countDownLatch);
        new Friend("Katty",countDownLatch);
        new Friend("Oleg",countDownLatch);
        new Friend("Marin",countDownLatch);
        new Friend("Anna",countDownLatch);

        marketStuffIsOnPlace();
        everythingIsReady();
        openMarket();

    }

}

class Friend extends Thread {

    private String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + " start shopping");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
