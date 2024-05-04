package ru.sgu;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<BasicInfo> deps = new ArrayList<>();
    private int empNum;

    public Company(String name) {
        this.name = name;
        this.empNum = 0;
    }

    public void addDepartment(BasicInfo department) {
        deps.add(department);
        empNum++;
    }

    public void removeDepartment(BasicInfo department) {
        deps.remove(department);
        empNum--;
    }

    public ArrayList<BasicInfo> getDepartments() {
        return deps;
    }

    @Override
    public String toString() {
        StringBuilder deps = new StringBuilder();
        for (BasicInfo dep : this.deps) {
            deps.append(dep.getDepartmentName() + ";\n");
        }
        return "Компания `" + this.name + "` имеет " + this.empNum + " отделов:\n" + deps;
    }
}

