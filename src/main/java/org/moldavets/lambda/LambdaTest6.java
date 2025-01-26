package org.moldavets.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class LambdaTest6 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 15, 25, 10, 30);

        List<Integer> result = numbers.stream().filter(i -> i > 10).map(i -> i * 2).toList();
        System.out.println(result);
    }
}
