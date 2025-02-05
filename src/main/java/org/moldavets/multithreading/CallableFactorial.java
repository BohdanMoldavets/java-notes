package org.moldavets.multithreading;

import java.util.concurrent.*;

public class CallableFactorial {

    private static int factorialResult;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Factorial2 factorial = new Factorial2(5);
        executor.submit(factorial);
        Future<Integer> future = executor.submit(factorial);
        try {
            factorialResult = future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            executor.shutdown();
        }
        System.out.println(factorialResult);
    }

}

class Factorial2 implements Callable<Integer> {

    private int n;

    public Factorial2(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        if(n <= 0) {
            throw new Exception("Invalid factorial number");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}