package org.moldavets.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableFactorial {

    static int factorialResult;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(6);
        executor.execute(factorial);
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(factorialResult);
    }
}

class Factorial implements Runnable {

    private int n;

    public Factorial(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        if(n <= 0) {
            System.out.println("Invalid factorial");
            return;
        }
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        RunnableFactorial.factorialResult = result;
    }
}
