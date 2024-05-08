package ru.sgu;

import java.math.BigDecimal;
import java.util.ArrayList;

interface BasicInfo {
    public String getDepartmentName();
    BigDecimal getTotalSalary();
    int getTotalNumberOfEmployees();
    public int compareTo(BasicInfo obj);
}

abstract public class Department {
    protected String name;

    public Department(String name) {
        this.name = name;
    }

    public abstract void hireEmployee(Employee employee);

    public abstract void fireEmployee(Employee employee);

    public abstract ArrayList<Employee> getEmployees();
}
