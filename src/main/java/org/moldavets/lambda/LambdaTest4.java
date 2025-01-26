package org.moldavets.lambda;

public class LambdaTest4 {

    public static void main(String[] args) {

        Calculator add = (a,b) -> a + b;
        Calculator mult = (a,b) -> a * b;

    }
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}
