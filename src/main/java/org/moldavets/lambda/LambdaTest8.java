package org.moldavets.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest8 {

    public static void main(String[] args) {

        Predicate<String> p1 = s -> s.startsWith("A");
        filterStrings(Arrays.asList("Alpaka", "Bat", "Chicken", "Albatrose"), p1);

    }
    static void filterStrings(List<String> strings, Predicate<String> condition) {
        strings.stream()
                .filter(condition)
                .forEach(System.out::println);
    }
}



