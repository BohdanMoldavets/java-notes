package org.moldavets.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest2 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        List<Integer> wordsLength = words.stream().map(String::length).toList();
        System.out.println(wordsLength);
    }

}
