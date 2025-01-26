package org.moldavets.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaTest9 {

    public static void main(String[] args) {

        List<Employee9> employees = Arrays.asList(
                new Employee9("Alice", "IT", 70000),
                new Employee9("Bob", "HR", 50000),
                new Employee9("Charlie", "IT", 80000),
                new Employee9("Diana", "HR", 60000)
        );

        Map<String,Double> departments =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(
                                Employee9::getDepartment,
                                Collectors.averagingInt(Employee9::getSalary)
                        )

        );

        System.out.println(departments);

    }

}

class Employee9 {
    private String name;
    private String department;
    private int salary;

    public Employee9() {
    }

    public Employee9(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee9{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
