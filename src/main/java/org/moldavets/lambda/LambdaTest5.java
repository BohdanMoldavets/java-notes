package org.moldavets.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest5 {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 70000),
                new Employee("Bob", 40000),
                new Employee("Charlie", 60000)
        );

        List<Employee> result = employees
                .stream()
                .filter(e -> e.getSalary() > 50000)
                .toList();
    }

}

class Employee {
    private String name;
    private int salary;

    public Employee() {
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
