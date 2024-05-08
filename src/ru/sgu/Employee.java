package ru.sgu;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private String position;
    private double salary;

    public Employee(String firstName, String lastName, String position, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }

    public Employee(Employee other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.position = other.position;
        this.salary = other.salary;
    }

    public Employee shallowCopy() {
        return new Employee(this);
    }

    public Employee deepCopy() {
        return new Employee(this.firstName, this.lastName, this.position, this.salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int compareTo(Employee emp) {
        if (this.salary > emp.salary)
            return 1;
        else if (this.salary < emp.salary)
            return -1;
        return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, position, salary);
    }

    @Override
    public String toString() {
        return "Работник{" +
                "Имя='" + firstName + '\'' +
                ", Фамилия='" + lastName + '\'' +
                ", Должность='" + position + '\'' +
                ", Зарплата=" + salary +
                '}';
    }
}

