package org.moldavets.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumNumbers {

    private static long value = 1_000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long valueDividedBy10 = value / 10;

        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<Long>> futureResults = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            long from = valueDividedBy10 * i + 1;
            long to = valueDividedBy10 * (i + 1);
            PartialSum task = new PartialSum(from, to);
            executor.submit(task);
            futureResults.add(executor.submit(task));
        }
        executor.shutdown();
        for(Future<Long> future : futureResults) {
            sum += future.get();
        }
        System.out.println("Total sum = " + sum);
    }
}

class PartialSum implements Callable<Long> {

    private final long from;
    private final long to;
    private long sum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        for (long i = from ; i <= to ; i++) {
            sum += i;
        }
        System.out.printf("Sum form %s to %s = %s\n", from, to, sum);
        return sum;
    }
}
