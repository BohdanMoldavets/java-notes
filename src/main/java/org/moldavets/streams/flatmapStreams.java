package org.moldavets.streams;

import org.moldavets.lambda.Student;

import java.util.ArrayList;
import java.util.List;

public class flatmapStreams {

    public static void main(String[] args) {

        Student student1 = new Student("John",18,4.3);
        Student student2 = new Student("Katy",20,4.7);
        Student student3 = new Student("Susan",24,4.8);
        Student student4 = new Student("Mary",19,5.0);

        Course course1 = new Course(1);
        Course course2 = new Course(2);

        course1.addStudentToCourse(student1);
        course1.addStudentToCourse(student2);
        course2.addStudentToCourse(student3);
        course2.addStudentToCourse(student4);

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);


        courses.stream()
                .flatMap(c -> c.getStudentList().stream())
                    .forEach(s -> System.out.println(s.getName()));

    }
}

class Course {

    private int course;
    private List<Student> studentList;

    public Course(int course) {
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void addStudentToCourse(Student student) {
        if(studentList == null) {
            studentList = new ArrayList<>();
        }
        studentList.add(student);
    }

    public List<Student> getStudentList() {
        if(studentList == null) {
            return null;
        }
        return studentList;
    }
}
