package org.moldavets.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 10; i++) {
            executorService.execute(new MyRunnableImpl());
        }
        executorService.shutdown();
//        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Main thread finished.");
    }
}

class MyRunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "begins work");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "end work!");

    }
}