package org.moldavets.lambda;

import java.util.ArrayList;
import java.util.List;

public class Lambda1 {

    public static void main(String[] args) {


        List<Student> students = new ArrayList<>();
        Student student1 = new Student("John", 18, 4.2);
        Student student2 = new Student("Katy", 24, 5.0);
        Student student3 = new Student("Marcin", 20, 3.5);


        students.add(student1);
        students.add(student2);
        students.add(student3);

        //StudentCheck sc = (Student s) -> s.getAvgGrade() < 5.0;
//        List<Student> result = checkStudents(students, (Student s) -> s.getAge() > 18);
//        System.out.println(result);

//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
//
//        Collections.sort(students, (s1,s2) -> s1.getAge() - s2.getAge());


    }

}

class info {

    public static List<Student> checkStudents(List<Student> students, StudentCheck sc) {
        for (Student s : students) {
            if(!sc.check(s)) {
                students.remove(s);
            }
        }
        return students;
    }

}

interface StudentCheck {
    boolean check(Student s);
}