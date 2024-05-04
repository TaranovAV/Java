package ru.sgu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class IT extends Department implements Comparable<BasicInfo>, BasicInfo {
    private ArrayList<Employee> employees;
    private String product;

    public IT(String name, String product) {
        super(name);
        employees = new ArrayList<>();
        this.product = product;
    }

    @Override
    public String getDepartmentName() {
        return this.name;
    }

    public void hireEmployee(Employee emp) {
        employees.add(emp);
    }

    public void fireEmployee(Employee emp) {
        employees.remove(emp);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public BigDecimal getTotalSalary() {
        BigDecimal totalSalary = new BigDecimal(0);
        for (Employee employee : employees) {
            totalSalary = totalSalary.add(new BigDecimal(employee.getSalary()));
        }
        return totalSalary;
    }

    public int getTotalNumberOfEmployees() {
        return employees.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        IT prod = (IT) obj;
        return Objects.equals(this.name, prod.name);
    }

    @Override
    public int compareTo(BasicInfo obj) {
        return this.getDepartmentName().compareTo(obj.getDepartmentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return "В отделе `" + this.name + "` ведется " + this.product;
    }
}
