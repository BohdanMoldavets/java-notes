package org.moldavets.streams;

import org.moldavets.lambda.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class groupingByStreams {
    public static void main(String[] args) {

        Student student1 = new Student("John",18,4.3);
        Student student2 = new Student("Katy",20,4.7);
        Student student3 = new Student("Susan",24,4.8);
        Student student4 = new Student("Mary",19,5.0);
        Student student5 = new Student("Jane",20,5.0);

        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Map<Integer,List<Student>> groupedBy = students.stream()
                .map(s -> {
            s.setName(s.getName().toUpperCase());
            return s;
        }
                ).collect(Collectors.groupingBy(Student::getAge));

        for(Map.Entry<Integer,List<Student>> entry : groupedBy.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for(Student student : entry.getValue()) {
                System.out.println(" " +student.getName());
            }
        }


    }
}
