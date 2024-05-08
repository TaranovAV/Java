package ru.sgu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class TechSupport extends Department implements Comparable<BasicInfo>, BasicInfo {

    private ArrayList<Employee> employees;

    public TechSupport(String name) {
        super(name);
        employees = new ArrayList<>();
    }

    public TechSupport(TechSupport other) {
        super(other.name);
        this.employees = new ArrayList<>(other.employees);
    }

    public TechSupport shallowCopy() {
        return new TechSupport(this);
    }

    public TechSupport deepCopy() {
        TechSupport copy = new TechSupport(this.name);
        copy.employees = new ArrayList<>();
        for (Employee employee : this.employees) {
            copy.employees.add(employee.deepCopy());
        }
        return copy;
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
        TechSupport prod = (TechSupport) obj;
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
        return "В отделе `" + this.name + "` оказывают техническую поддержку";
    }
}
