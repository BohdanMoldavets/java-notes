package org.moldavets.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest7 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 15, 25, 10, 30);

        System.out.println("Min: " + numbers.stream().reduce(Integer::min).get());
        System.out.println("Max: " + numbers.stream().reduce(Integer::max).get());



    }
}
