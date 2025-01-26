package org.moldavets.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest3 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom", "Jerry", "Alexandra", "Bob");

        names.sort(String::compareTo);

        System.out.println(names);
    }

}
