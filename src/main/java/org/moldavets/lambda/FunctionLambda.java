package org.moldavets.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionLambda {
    public static void main(String[] args) {

        List<Student> students = Stream.of(
                new Student("John",18,4.3),
                new Student("Katy",20,4.7),
                new Student("Susan",24,4.8)
        ).toList();

        System.out.println(testFunction.avgOfSmth(students, student -> (double) student.getAge()));
    }
}

class testFunction {

    public static double avgOfSmth(List<Student> students, Function<Student, Double> function) {

        double result = 0;

        for(Student student : students) {
            result += function.apply(student);
        }

        return result / students.size();
    }

}
