package org.moldavets.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {


    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

//        for (int i = 0; i < 10; i++) {
//            scheduler.execute(new MyRunnableImpl1());
//        }
//        scheduler.schedule(
//                new MyRunnableImpl1(),
//                3,
//                TimeUnit.SECONDS
//        );
        scheduler.scheduleAtFixedRate(
                new MyRunnableImpl1(),
                3,
                1,
                TimeUnit.SECONDS
        );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        scheduler.shutdown();

    }
}

class MyRunnableImpl1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "begins work");
        System.out.println(Thread.currentThread().getName() + "end work!");
    }
}