package org.moldavets.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.moldavets.lambda.StudentInfo.checkStudentsList;

public class PredicateLambda {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        Student student1 = new Student("John", 18, 4.2);
        Student student2 = new Student("Katy", 24, 5.0);
        Student student3 = new Student("Marcin", 20, 3.5);


        students.add(student1);
        students.add(student2);
        students.add(student3);

        Predicate<Student> predicate = student -> student.getAge() >= 19;
        System.out.println(checkStudentsList(students, predicate));

    }
}

class StudentInfo {
    public static List<Student> checkStudentsList(List<Student> students, Predicate<Student> predicate) {
        students.removeIf(predicate);
        return students;
    }
}